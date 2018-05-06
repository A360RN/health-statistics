# The World Bank - Health Stats API

## API Endpoint: [https://health-statistics-rest-api.appspot.com/api/v1/stats/health] (https://health-statistics-rest-api.appspot.com/api/v1/stats/health)

Specification:

<strong>/</strong> :
Returns health statistics 
  <strong>Query params</strong>:
    year: Number. Example: 2013
    countryCode: String. Example: ARG

  <strong>Response</strong>:
    total: Number
    valueTotal: Number
    data: Object
      stats: Array
        stat: Object 
          seriesCode: String
          seriesName: String
          countryCode: String
          countryName: String
          year: Number
          value: Number
