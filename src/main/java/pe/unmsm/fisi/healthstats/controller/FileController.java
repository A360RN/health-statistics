package pe.unmsm.fisi.healthstats.controller;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

@Controller
public class FileController {
	
	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("HealthStat");

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	@ResponseBody
	public void fileUpload(@RequestParam("file") MultipartFile excel) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> itRow = sheet.iterator();
			int rows = 0;

			while (itRow.hasNext() && rows < 10) {
				Row currentRow = itRow.next();

				String seriesName = currentRow.getCell(0).getStringCellValue();
				String seriesCode = currentRow.getCell(1).getStringCellValue();
				String countryCode = currentRow.getCell(3).getStringCellValue();
				String countryName = currentRow.getCell(2).getStringCellValue();
				for(int i = 2005; i <= 2013; i++) {
					double value = currentRow.getCell(i-2001).getNumericCellValue();
					int year = i;
					Key newKey = datastore.allocateId(keyFactory.newKey());
					Entity newStat = Entity.newBuilder(newKey)
							.set("seriesCode", seriesCode)
							.set("seriesName", seriesName)
							.set("countryCode", countryCode)
							.set("countryName", countryName)
							.set("year", year)
							.set("value", value)
							.build();
					datastore.put(newStat);
				}
				rows++;
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
