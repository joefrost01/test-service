Feature: Book Service API

  Scenario: Create and retrieve a book
    Given a book exists with an id of 1
    When I retrieve the book with id 1
    Then the book title should be "Sample Book"

  Scenario: Update a book
    Given a book exists with an id of 1
    When I update the book with id 1 to have the title "Updated Book"
    Then the book title should be "Updated Book"

  Scenario: Delete a book
    Given a book exists with an id of 1
    When I delete the book with id 1
    Then the book should not exist with id 1
