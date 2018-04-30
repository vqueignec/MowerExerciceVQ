package mower;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.DirectionsEnum;
import enums.MoveEnum;
import environment.World;
import mower.logic.MoveCommand;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author - v.queignec
 */
public class MowerStepDefs {
    private Mower mower1;

    @Given("^the field (\\d+) (\\d+) with a mower (\\d+) (\\d+) (.+)$")
    public void theFieldWithAMowerN(int fieldX, int fieldY, int x, int y, String direction){
        World.initField(fieldX, fieldY);
        mower1 = new Mower(x, y, DirectionsEnum.valueOf(direction));
    }

    @When("^I use Command (.+)$")
    public void iUseCommandA(String command){
        mower1.applyCommand(new MoveCommand(MoveEnum.valueOf(command)));
    }

    @Then("^My mower is on (\\d+) (\\d+) (.+)$")
    public void myMowerIsStillOn(int x, int y, String orient){
        assertThat(mower1.getPosition().getX(), is(x));
        assertThat(mower1.getPosition().getY(), is(y));
        assertThat(mower1.getDirection(), is(DirectionsEnum.valueOf(orient)));
    }

    @When("^I use the list of commands (.+)$")
    public void iUseTheListOfCommands(String commands) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the field (\\d+) (\\d+) with a mower (\\d+) (\\d+) (.+) and a mower (\\d+) (\\d+) (.+)$")
    public void theFieldWithAMowerxNAndAMowerE(int fieldX, int fieldY, int m1X, int m1Y, String m1D, int m2X, int m2Y, String m2D) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I use the list of commands (.+) and (.+)$")
    public void iUseTheListOfCommands(String command1, String command2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
