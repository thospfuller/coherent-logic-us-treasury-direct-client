/*
 *
 */
import joinery.DataFrame
import joinery.DataFrame.PlotType

import java.text.SimpleDateFormat

import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType

// "effectiveDate":"January 31, 2014 EST"
def sdf = new SimpleDateFormat ("MMMM dd, yyyy zzz")

/*
 * http://www.treasurydirect.gov/NP_WS/debt/search?startdate=2014-01-01&enddate=2014-02-01
 */
def debts = queryBuilder.debt().search().withStartDate("1966-01-01").withEndDate ("2016-11-01").doGetAsDebts()

def dataFrame = new DataFrame<Object> ()

def dates = [] as List
def values = [] as List<BigDecimal>

debts.debtList.reverse ()

debts.debtList.forEach {
    dates << sdf.parse (it.effectiveDate)
    values << new BigDecimal (it.totalDebt)
}

println "dates: ${dates}"
println "values: ${values}"

dataFrame.add((Object) "Dates", (List<Object>) dates)
dataFrame.add((Object) "Total Debt", (List<Object>) values)

dataFrame.plot(PlotType.LINE)
dataFrame.show()

return debts