package mower;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.DirectionsEnum;
import enums.ActionsEnum;
import environment.World;
import environment.exceptions.ThatsMyHomeException;
import mower.logic.Command;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author - v.queignec
 */
public class MowerStepDefs {

    @Given("^the field (\\d+) (\\d+) with only one mower (\\d+) (\\d+) (.+)$")
    public void theFieldWithAMower(int fieldX, int fieldY, int x, int y, String direction){
        initField(fieldX, fieldY);
        try {
            World.addAnElement(getMowerGivenPositionAndDirection(x, y, direction));
        } catch (ThatsMyHomeException e) {
            assertFalse(true);
        }
    }

    @Then("^My mower is on (\\d+) (\\d+) (.+)$")
    public void myMowerIsStillOn(int x, int y, String orient){
        AbstractElement ele = World.getElements().get(0);
        assertThat(ele.getPosition().getX(), is(x));
        assertThat(ele.getPosition().getY(), is(y));
        assertThat(ele.getDirection(), is(DirectionsEnum.valueOf(orient)));
    }

    @When("^I use one list of commands (.+)$")
    public void iUseTheListOfCommands(String commands) throws Throwable {
        AbstractElement ele = World.getElements().get(0);
        addListOfCommandsToTheGivenElement(commands, ele);
        World.play();
    }

    @Given("^the field (\\d+) (\\d+) with a mower (\\d+) (\\d+) (.+) and a mower (\\d+) (\\d+) (.+)$")
    public void theFieldWithAMowerAndAMower(int fieldX, int fieldY, int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) throws Throwable {
        initField(fieldX, fieldY);
        World.addAnElement(getMowerGivenPositionAndDirection(m1X, m1Y, m1D));
        World.addAnElement(getMowerGivenPositionAndDirection(m2X, m2Y, m2D));
    }

    @When("^I use the list of commands (.+) and (.+)$")
    public void iUseTheListOfCommands(String commands1, String commands2) throws Throwable {
        AbstractElement ele1 = World.getElements().get(0);
        AbstractElement ele2 = World.getElements().get(1);
        addListOfCommandsToTheGivenElement(commands1, ele1);
        addListOfCommandsToTheGivenElement(commands2, ele2);
    }

    @Then("^the field is mower at (\\d+) (\\d+)$")
    public void theFieldIsMowerAt(int fieldX, int fieldY) throws Throwable {
        assertThat(World.getField()[fieldX][fieldY].isMowed(), is(true));
    }

    @Then("^My mowers are on (\\d+) (\\d+) (.+) and (\\d+) (\\d+) (.+)$")
    public void myMowersAreOn(int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) throws Throwable {

    }

    private void initField(int fieldX, int fieldY){
        World.init(fieldX, fieldY);
    }

    private Mower getMowerGivenPositionAndDirection(int x, int y, String direction){
        return Mower.builder().x(x).y(y).direction(DirectionsEnum.valueOf(direction)).build();
    }

    private void addListOfCommandsToTheGivenElement(String commands, AbstractElement ele){
        CharacterIterator it = new StringCharacterIterator(commands);

        while (it.current() != CharacterIterator.DONE) {
            ele.addCommand(Command.builder().order(ActionsEnum.valueOf(String.valueOf(it.current()))).build());
            it.next();
        }
    }
}
