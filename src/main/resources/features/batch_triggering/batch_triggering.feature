Feature: Batch service triggering

  Scenario: Run batch
    Given the batch date is set to the provided date
    When I execute the batch for that date
    Then the batch should execute 100 jobs successfully
