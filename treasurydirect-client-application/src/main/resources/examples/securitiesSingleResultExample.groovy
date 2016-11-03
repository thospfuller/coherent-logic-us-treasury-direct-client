/*
 *
 */
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType

def securities = queryBuilder.securities(SecurityType.FRN).doGetAsSecurities()

return securities