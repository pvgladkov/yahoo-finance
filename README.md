# Yahoo Finance API

Example:
```scala
import cc.p2k.yahoo.finance.Stock

val s = Stock("aapl")
print(s.price)
```


Output:

```
111.31
```

## Historical Quotes

Example:
```scala
import cc.p2k.yahoo.finance.HistoryStock

val d = HistoryStock("googl", "2014-10-05", "2014-10-10", "d")
println(d("2014-10-06").open)
```

Output:

```
589.950012
```

### Trading periods:

"d" - daily

"w" - weekly

"m" - monthly

### Fields:

date

open

high

low

close

volume

adjClose

#### links:

1. https://code.google.com/p/yahoo-finance-managed/wiki/csvQuotesDownload

2. https://code.google.com/p/yahoo-finance-managed/wiki/csvHistQuotesDownload