# The World Bank - Health Stats API

## API Endpoint: https://health-statistics-rest-api.appspot.com/api/v1/stats/health

Specification:

<strong>/</strong> :
Returns health statistics</br>
&nbsp;&nbsp;<strong>Query params</strong>:</br>
&nbsp;&nbsp;&nbsp;&nbsp;year: Number. Example: 2013</br>
&nbsp;&nbsp;&nbsp;&nbsp;countryCode: String. Example: ARG</br></br>

<strong>Response</strong>:</br>
&nbsp;&nbsp;data: Object</br>
&nbsp;&nbsp;&nbsp;&nbsp;total: Number</br>
&nbsp;&nbsp;&nbsp;&nbsp;valueTotal: Number</br>
&nbsp;&nbsp;&nbsp;&nbsp;stats: Array</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;stat: Object</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seriesCode: String</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seriesName: String</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;countryCode: String</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;countryName: String</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;year: Number</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;value: Number</br>
