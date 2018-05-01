package mower;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ActionsEnum;
import enums.DirectionsEnum;
import environment.World;
import environment.exceptions.ThatsMyHomeException;
import mower.logic.Command;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author - v.queignec
 */
public class MowerStepDefs {

    @Given("^the field (\\d+) (\\d+) with only one mower (\\d+) (\\d+) (.+)$")
    public void theFieldWithAMower(int fieldX, int fieldY, int x, int y, String direction) {
        initField(fieldX, fieldY);
        try {
            World.addAnElement(getMowerGivenPositionAndDirection(x, y, direction));
        } catch (ThatsMyHomeException e) {
            //Not possible
            assertFalse(true);
        }
    }

    @Then("^My mower is on (\\d+) (\\d+) (.+)$")
    public void myMowerIsOn(int x, int y, String orient) {
        AbstractElement ele = World.getElements().get(0);
        assertThat(ele.getPosition().getX(), is(x));
        assertThat(ele.getPosition().getY(), is(y));
        assertThat(ele.getDirection(), is(DirectionsEnum.valueOf(orient)));
    }

    @When("^I use one list of commands (.+)$")
    public void iUseTheListOfCommands(String commands) {
        AbstractElement ele = World.getElements().get(0);
        addListOfCommandsToTheGivenElement(commands, ele);
        World.play();
    }

    @Given("^the field (\\d+) (\\d+) with two valid mowers (\\d+) (\\d+) (.+) and (\\d+) (\\d+) (.+)$")
    public void theFieldWithTwoValidMowers(int fieldX, int fieldY, int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) {
        initField(fieldX, fieldY);
        try {
            World.addAnElement(getMowerGivenPositionAndDirection(m1X, m1Y, m1D));
            World.addAnElement(getMowerGivenPositionAndDirection(m2X, m2Y, m2D));
        } catch (ThatsMyHomeException e) {
            assertFalse(true);
        }
    }

    @When("^I use the list of commands (.+) and (.+)$")
    public void iUseTheListOfCommands(String commands1, String commands2) {
        AbstractElement ele1 = World.getElements().get(0);
        AbstractElement ele2 = World.getElements().get(1);
        addListOfCommandsToTheGivenElement(commands1, ele1);
        addListOfCommandsToTheGivenElement(commands2, ele2);
        World.play();
    }

    @Then("^the field is mowed at (\\d+) (\\d+)$")
    public void theFieldIsMowedAt(int fieldX, int fieldY) {
        assertThat(World.getField()[fieldX][fieldY].isMowed(), is(true));
    }

    @Then("^My mowers are on (\\d+) (\\d+) (.+) and (\\d+) (\\d+) (.+)$")
    public void myMowersAreOn(int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) {
        AbstractElement ele1 = World.getElements().get(0);
        AbstractElement ele2 = World.getElements().get(1);

        assertThat(ele1.getPosition().getX(), is(m1X));
        assertThat(ele1.getPosition().getY(), is(m1Y));
        assertThat(ele1.getDirection(), is(DirectionsEnum.valueOf(m1D)));

        assertThat(ele2.getPosition().getX(), is(m2X));
        assertThat(ele2.getPosition().getY(), is(m2Y));
        assertThat(ele2.getDirection(), is(DirectionsEnum.valueOf(m2D)));
    }

    @Given("^the field (\\d+) (\\d+) with two mowers at the same position (\\d+) (\\d+) (.+) and (\\d+) (\\d+) (.+)$")
    public void theFieldWithTwoMowersAtTheSamePosition(int fieldX, int fieldY, int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) {
        initField(fieldX, fieldY);
        try {
            World.addAnElement(getMowerGivenPositionAndDirection(m1X, m1Y, m1D));
            World.addAnElement(getMowerGivenPositionAndDirection(m2X, m2Y, m2D));
        } catch (ThatsMyHomeException e) {
            assertTrue(true);
        }
    }

    private void initField(int fieldX, int fieldY) {
        World.init(fieldX, fieldY);
    }

    private Mower getMowerGivenPositionAndDirection(int x, int y, String direction) {
        return Mower.builder().x(x).y(y).direction(DirectionsEnum.valueOf(direction)).build();
    }

    private void addListOfCommandsToTheGivenElement(String commands, AbstractElement ele) {
        CharacterIterator it = new StringCharacterIterator(commands);

        while (it.current() != CharacterIterator.DONE) {
            ele.addCommand(Command.builder().order(ActionsEnum.valueOf(String.valueOf(it.current()))).build());
            it.next();
        }
    }
}
