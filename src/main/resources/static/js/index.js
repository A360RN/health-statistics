(function() {
	btnStartClicked();
})();

function btnStartClicked() {
	$('#btnStart').on('click', () => {
		window.location.href = '/data';
	});
}