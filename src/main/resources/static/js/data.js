init();

function init(){
	initBtnEventListeners();
}

function initBtnEventListeners() {
	btnSearchClicked();
	btnGeneralReportClicked();
	btnChartClicked();
}

function btnSearchClicked() {
	$('#btnSearch').on('click', (evt) => {
		evt.preventDefault();
		$('#btnSearch').attr('disabled', true);
		const queryString = getQueryParams();
		let url = '/api/v1/stats/health'
		if (queryString.length > 0) {
			url = url + '?' + queryString;
		}
		$.ajax({
			method:'GET',
			url: url
		}).done((response) => {
			const tableHtml = createTable(response);
			createChart(response);
			$('#table-container').html(tableHtml);
			$('#btnSearch').attr('disabled', false);
		}).fail((err) => {
			$('#btnSearch').attr('disabled', false);
			console.log(err);
		});	
	});
}

function getQueryParams() {
	const seriesCode = $('#seriesCode').val();
	const countryCode = $('#countryCode').val();
	let queryString = '';
	if (seriesCode !== '0') {
		queryString += `seriesCode=${seriesCode}&`;
	}
	
	if(countryCode !== '0') {
		queryString += `countryCode=${countryCode}&`;
	}
	queryString = queryString.substring(0, queryString.length - 1);
	return queryString;
}

function createTable(payload) {
	let html = '<div class="table-responsive"><table class="table table-bordered"><thead>';
	html+= '<tr><th>Indicador</th><th>Pais</th><th>Año</th><th>Valor</th></tr></thead><tbody>';
	const data = payload.data.stats;
	data.forEach((el) => {
		const {
			countryName,
			seriesName,
			year,
			value
		} = el;
		html += '<tr>';
		html += '<td>' + seriesName + '</td>';
		html += '<td>' + countryName + '</td>';
		html += '<td>' + year + '</td>';
		html += '<td>' + value + '</td>';
		html += '</tr>';
	})
	html += '</tbody></table></div>';
	return html;
}

function createChart(payload) {
	const data = payload.data.stats;
	const labels = ['2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013'];
	let argData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let bolData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let braData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let chlData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let colData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let ecuData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let pryData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let perData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let uryData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	let venData = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];
	
	data.forEach((el) => {
		const countryCode = el.countryCode;
		if (countryCode === 'ARG') {
			const { year, value } = el; 
			argData[year-2005] = value;
		} else if(countryCode === 'BOL') {
			const { year, value } = el; 
			bolData[year-2005] = value;
		} else if(countryCode === 'BRA') {
			const { year, value } = el; 
			braData[year-2005] = value;
		} else if(countryCode === 'CHL') {
			const { year, value } = el; 
			chlData[year-2005] = value;
		} else if(countryCode === 'COL') {
			const { year, value } = el; 
			colData[year-2005] = value;
		} else if(countryCode === 'ECU') {
			const { year, value } = el; 
			ecuData[year-2005] = value;
		} else if(countryCode === 'PRY') {
			const { year, value } = el; 
			pryData[year-2005] = value;
		} else if(countryCode === 'PER') {
			const { year, value } = el; 
			perData[year-2005] = value;
		} else if(countryCode === 'URY') {
			const { year, value } = el; 
			uryData[year-2005] = value;
		} else if(countryCode === 'VEN') {
			const { year, value } = el; 
			venData[year-2005] = value;
		}
	});
	
	const chartContext = document.getElementById('chart').getContext('2d');
	const chart = new Chart(chartContext, {
		type: 'line',
		data: {
			labels: labels,
			datasets: [
				{
					label: 'Argentina',
					backgroundColor: 'rgba(0, 0, 255, 0.5)',
					borderColor: 'rgb(0, 0, 255)',
					fill: false,
					data: argData
				},
				{
					label: 'Bolivia',
					backgroundColor: 'rgba(0, 255, 0, 0.5)',
					borderColor: 'rgb(0, 255, 0)',
					fill: false,
					data: bolData
				},
				{
					label: 'Brazil',
					backgroundColor: 'rgba(242,46,224, 0.5)',
					borderColor: 'rgb(242,46,224)',
					fill: false,
					data: braData
				},
				{
					label: 'Chile',
					backgroundColor: 'rgba(151,204,125, 0.5)',
					borderColor: 'rgb(151,204,125)',
					fill: false,
					data: chlData
				},
				{
					label: 'Colombia',
					backgroundColor: 'rgba(181,136,232, 0.5)',
					borderColor: 'rgb(181,136,232)',
					fill: false,
					data: colData
				},
				{
					label: 'Ecuador',
					backgroundColor: 'rgba(154,249,223, 0.5)',
					borderColor: 'rgb(154,249,223)',
					fill: false,
					data: ecuData
				},
				{
					label: 'Paraguay',
					backgroundColor: 'rgba(0, 0, 255, 0.5)',
					borderColor: 'rgb(0, 0, 255)',
					fill: false,
					data: pryData
				},
				{
					label: 'Peru',
					backgroundColor: 'rgba(255, 0, 0, 0.5)',
					borderColor: 'rgb(255, 0, 0)',
					fill: false,
					data: perData
				},
				{
					label: 'Uruguay',
					backgroundColor: 'rgba(29,156,223, 0.5)',
					borderColor: 'rgb(29,156,223)',
					fill: false,
					data: uryData
				},
				{
					label: 'Venezuela',
					backgroundColor: 'rgba(213,192,89 0.5)',
					borderColor: 'rgb(213,192,89)',
					fill: false,
					data: venData
				},
			]
		}
	});
}

function btnGeneralReportClicked() {
	$('#btnGeneralReport').on('click', () => {
		$('#table-container').attr('hidden', false);
		$('#chart-container').attr('hidden', true);
	});
}

function btnChartClicked() {
	$('#btnChart').on('click', () => {
		$('#table-container').attr('hidden', true);
		$('#chart-container').attr('hidden', false);
	});
}
