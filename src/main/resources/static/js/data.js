(function(){
	btnSearchClicked();
})();

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