@SearchTable
Feature: Search for an item

	Background:
	Given open browser
	
	
	Scenario: Search for stainless work table
		When User search for "stainless work table"
		And User click search button
		Then All the items with table name will show up
		Then Add the last of found items to Cart
		Then Empty cart
		Then Your cart is Empty is displayed