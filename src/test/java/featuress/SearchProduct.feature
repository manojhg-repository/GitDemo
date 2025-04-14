Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for Product search in both home page and offers page

Given User is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of the product
Then user searched same shortname <Name> in offers page 
And validate product name in offers page matches with Landing page

Examples:
| Name |
| Tom  |
| Beet |

