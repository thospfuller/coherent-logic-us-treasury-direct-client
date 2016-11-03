/*
 *
 */
import joinery.DataFrame
import joinery.DataFrame.PlotType

import java.text.SimpleDateFormat

import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType

def sdf = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss")

def securities = queryBuilder.securities(SecurityType.Bill).doGetAsSecurities()

def cusips = []

securities.securityList.each {
    cusips << it.cusip
}

def ctr = 0

cusips.each { itA ->
    cusips.each { itB ->
        if (itA.equals (itB)) {
            ctr++
        }
    }
    println "cusip: $itA was found $ctr times."
    ctr = 0
}

def dataFrame = new DataFrame<Object> ()

def securitiesDates = [] as List
def securitiesValues = [] as List<BigDecimal>

securities.securityList.forEach {
    if ("912796HQ5".equals (it.cusip)) {
        securitiesDates << sdf.parse (it.issueDate)
        securitiesValues << new BigDecimal (it.competitiveTendered)
    }
}

println "securitiesDates: ${securitiesDates}"
println "securitiesValues: ${securitiesValues}"

dataFrame.add((Object) "Securities Date", (List<Object>) securitiesDates)
dataFrame.add((Object) "Securities Values", (List<Object>) securitiesValues)

dataFrame.plot(PlotType.LINE)
dataFrame.show()

return null // securities