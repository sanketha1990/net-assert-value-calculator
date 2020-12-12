# Quick Start 
```
A portfolio management firm invests money on their behalf to
generate profits. The firm buys securities / contracts (in layman terms shares/stocks) from the
market and sells them to realise the profit / losses. The Net Asset Value (NAV) is the net value
of all the securities held by the firm on the given day
Let say the firm holds the below securitiesn that

```

## Building
>The main method of the application is at the following path:
> ##### com.turvo.NetAssertValueCalculatorApplication

## Dependencies 
```

1.lombok
2.spring-boot-starter-web
3.gson

```

## Parameters File Example

```
############ Application configuration #############
server.port=9000
url.holding=https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding
url.pricing=https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing
####################################################

```

## Executing

Deploy the jar or code to AWS beanStalk and add the query parameter and url in the AWS API gateway.
This API which gives the calculated net assert value.
```
GET: http://localhost:9000/netValue/getDetails

```
## Response sample

```
{
"20190101": 812010.36,
"20190102": 164030.7,
"20190103": 104002.04,
"20190104": 225230.44,
"20190105": 185510.34,
"20190106": 922467.7199999999,
"20190107": 747847.1100000001,
}
```
