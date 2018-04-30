Feature: Mower Behavior

  Scenario: The Mower can't go beyond limits
    Given the field 5 5 with a mower 0 5 N
    When I use Command A
    Then My mower is on 0 5 N

  Scenario: The Mower turn to the left
    Given the field 5 5 with a mower 0 5 N
    When I use Command G
    Then My mower is on 0 5 W

  Scenario: The Mower turn to the right
    Given the field 5 5 with a mower 0 5 E
    When I use Command D
    Then My mower is on 0 5 S

  Scenario: The Mower moves up
    Given the field 5 5 with a mower 0 0 N
    When I use Command A
    Then My mower is on 0 1 N

  Scenario: The Mower moves down
    Given the field 5 5 with a mower 2 2 S
    When I use Command A
    Then My mower is on 2 1 S

  Scenario: The Mower moves left
    Given the field 5 5 with a mower 2 2 W
    When I use Command A
    Then My mower is on 1 2 W

  Scenario: The Mower moves right
    Given the field 5 5 with a mower 2 2 E
    When I use Command A
    Then My mower is on 3 2 E

  Scenario: One Mower with one list of commands
    Given the field 5 5 with a mower 1 2 N
    When I use the list of commands GAGAGAGAA
    Then My mower is on 1 3 N

  Scenario: Two Mowers with one list of commands each
    Given the field 5 5 with a mower 1 2 N and a mower 3 3 E
    When I use the list of commands GAGAGAGAA and AADAADADDA
    Then My mower is on 1 3 N