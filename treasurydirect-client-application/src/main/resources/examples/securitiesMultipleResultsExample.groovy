/*
 *
 */
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType

def securities = queryBuilder.securities(SecurityType.Bill).doGetAsSecurities()

return securities