def names = '''cusip
issueDate
securityType
securityTerm
maturityDate
interestRate
refCpiOnIssueDate
refCpiOnDatedDate
announcementDate
auctionDate
auctionDateYear
datedDate
accruedInterestPer1000
accruedInterestPer100
adjustedAccruedInterestPer1000
adjustedPrice
allocationPercentage
allocationPercentageDecimals
announcedCusip
auctionFormat
averageMedianDiscountRate
averageMedianInvestmentRate
averageMedianPrice
averageMedianDiscountMargin
averageMedianYield
backDated
backDatedDate
bidToCoverRatio
callDate
callable
calledDate
cashManagementBillCMB
closingTimeCompetitive
closingTimeNoncompetitive
competitiveAccepted
competitiveBidDecimals
competitiveTendered
competitiveTendersAccepted
corpusCusip
cpiBaseReferencePeriod
currentlyOutstanding
directBidderAccepted
directBidderTendered
estimatedAmountOfPubliclyHeldMaturingSecuritiesByType
fimaIncluded
fimaNoncompetitiveAccepted
fimaNoncompetitiveTendered
firstInterestPeriod
firstInterestPaymentDate
floatingRate
frnIndexDeterminationDate
frnIndexDeterminationRate
highDiscountRate
highInvestmentRate
highPrice
highDiscountMargin
highYield
indexRatioOnIssueDate
indirectBidderAccepted
indirectBidderTendered
interestPaymentFrequency
lowDiscountRate
lowInvestmentRate
lowPrice
lowDiscountMargin
lowYield
maturingDate
maximumCompetitiveAward
maximumNoncompetitiveAward
maximumSingleBid
minimumBidAmount
minimumStripAmount
minimumToIssue
multiplesToBid
multiplesToIssue
nlpExclusionAmount
nlpReportingThreshold
noncompetitiveAccepted
noncompetitiveTendersAccepted
offeringAmount
originalCusip
originalDatedDate
originalIssueDate
originalSecurityTerm
pdfFilenameAnnouncement
pdfFilenameCompetitiveResults
pdfFilenameNoncompetitiveResults
pdfFilenameSpecialAnnouncement
pricePer100
primaryDealerAccepted
primaryDealerTendered
reopening
securityTermDayMonth
securityTermWeekYear
series
somaAccepted
somaHoldings
somaIncluded
somaTendered
spread
standardInterestPaymentPer1000
strippable
term
tiinConversionFactorPer1000
tips
totalAccepted
totalTendered
treasuryDirectAccepted
treasuryDirectTendersAccepted
type
unadjustedAccruedInterestPer1000
unadjustedPrice
updatedTimestamp
xmlFilenameAnnouncement
xmlFilenameCompetitiveResults
xmlFilenameSpecialAnnouncement'''

/*
names = '''effectiveDate
governmentHoldings
publicDebt
totalDebt'''
*/

def methodsFile = new File('C:/Temp/methods.txt')

methodsFile.delete ()

names.eachLine { it ->
    def nextLine = """\n        if (!securityObject.has(\"$it\"))
            throw new ConversionFailedException("The JSON does not contain a member with name $it");

        String $it = securityObject.get(\"$it\").getAsString();

        log.debug("$it: " + $it);

        security.set${it.capitalize ()}($it);
"""

    println nextLine

    methodsFile << nextLine
}

methodsFile