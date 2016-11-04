def names = '''Cusip
IssueDate
SecurityType
SecurityTerm
MaturityDate
InterestRate
RefCpiOnIssueDate
AnnouncementDate
AuctionDate
XmlFilenameCompetitiveResults
DatedDate
RefCpiOnDatedDate
AccruedInterestPer1000
AccruedInterestPer100
AdjustedAccruedInterestPer1000
AdjustedPrice
AllocationPercentage
AllocationPercentageDecimals
AnnouncedCusip
AuctionFormat
AverageMedianDiscountRate
AverageMedianInvestmentRate
AverageMedianPrice
AverageMedianDiscountMargin
AverageMedianYield
BackDated
BackDatedDate
BidToCoverRatio
CallDate
Callable
CalledDate
CashManagementBillCMB
ClosingTimeCompetitive
ClosingTimeNoncompetitive
CompetitiveAccepted
CompetitiveBidDecimals
CompetitiveTendered
CompetitiveTendersAccepted
CorpusCusip
CpiBaseReferencePeriod
CurrentlyOutstanding
DirectBidderAccepted
DirectBidderTendered
EstimatedAmountOfPubliclyHeldMaturingSecuritiesByType
FimaIncluded
FimaNoncompetitiveAccepted
FimaNoncompetitiveTendered
FirstInterestPeriod
FirstInterestPaymentDate
FloatingRate
FrnIndexDeterminationDate
FrnIndexDeterminationRate
HighDiscountRate
HighInvestmentRate
HighPrice
HighDiscountMargin
HighYield
IndexRatioOnIssueDate
IndirectBidderAccepted
IndirectBidderTendered
InterestPaymentFrequency
LowDiscountRate
LowInvestmentRate
LowPrice
LowDiscountMargin
LowYield
MaturingDate
MaximumCompetitiveAward
MaximumNoncompetitiveAward
MaximumSingleBid
MinimumBidAmount
MinimumStripAmount
MinimumToIssue
MultiplesToBid
MultiplesToIssue
NlpExclusionAmount
NlpReportingThreshold
NoncompetitiveAccepted
NoncompetitiveTendersAccepted
OfferingAmount
OriginalCusip
OriginalDatedDate
OriginalIssueDate
OriginalSecurityTerm
PdfFilenameAnnouncement
PdfFilenameCompetitiveResults
PdfFilenameNoncompetitiveResults
PdfFilenameSpecialAnnouncement
PricePer100
PrimaryDealerAccepted
PrimaryDealerTendered
Reopening
SecurityTermDayMonth
SecurityTermWeekYear
Series
SomaAccepted
SomaHoldings
SomaIncluded
SomaTendered
Spread
StandardInterestPaymentPer1000
Strippable
Term
TiinConversionFactorPer1000
Tips
TotalAccepted
TotalTendered
TreasuryDirectAccepted
TreasuryDirectTendersAccepted
Type
UnadjustedAccruedInterestPer1000
UnadjustedPrice
UpdatedTimestamp
XmlFilenameAnnouncement
XmlFilenameSpecialAnnouncement
AuctionDateYear'''

def methodsFile = new File('C:/Temp/methods.txt')

methodsFile.delete ()

//withFieldAndValue (Field field, String value) {

names.eachLine { it ->
    def nextLine = """\n
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder with$it (String value) {
        return withFieldAndValue (Field.${it}, value);
    }

    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder with${it}AsNotNull () {
        return withFieldAndValue (Field.${it}, NOT_NULL);
    }"""

    println nextLine
    
    if (it.endsWith ("Date")) {
        nextLine +=
    """
    /**
     * @see <a href="https://www.treasurydirect.gov/webapis/webapisecurities.htm">Treasury Security Information</a>
     */
    public QueryBuilder with${it}AsToday () {
        return withFieldAndValue (Field.${it}, TODAY);
    }"""
    }

    methodsFile << nextLine
}

methodsFile