Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for Product search in both home page and offers page

Given User is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of the product
And added "3" items of the selected product to the cart
Then user proceeds to checkout and validate the <Name> items in checkout page
And verify the user has the ability to enter promocode and place the order

Examples:
| Name |
| Tom  |


