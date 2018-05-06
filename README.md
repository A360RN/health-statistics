# The World Bank - Health Stats API

## API Endpoint: https://health-statistics-rest-api.appspot.com/api/v1/stats/health

Specification:

<strong>/</strong> :
Returns health statistics 
&nbsp;&nbsp;<strong>Query params</strong>:
&nbsp;&nbsp;&nbsp;&nbsp;year: Number. Example: 2013
&nbsp;&nbsp;&nbsp;&nbsp;countryCode: String. Example: ARG

<strong>Response</strong>:
&nbsp;&nbsp;total: Number
&nbsp;&nbsp;valueTotal: Number
&nbsp;&nbsp;data: Object
&nbsp;&nbsp;&nbsp;&nbsp;stats: Array
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;stat: Object 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seriesCode: String
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seriesName: String
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;countryCode: String
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;countryName: String
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;year: Number
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;value: Number
