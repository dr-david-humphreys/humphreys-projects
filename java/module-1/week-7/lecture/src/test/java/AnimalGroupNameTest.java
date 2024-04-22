import com.techelevator.AnimalGroupName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnimalGroupNameTest {

    /* If a method is annotated with @Before, it will be executed immediately prior to every test.
     * It is intended to be used when there is a repetitive setup (i.e. "Arrange") task that is
     * performed by several tests */
    @Before
    public void setup() {
        System.out.println("setup");
    }

    /* If a method is annotated with @After, it will be executed immediately after every test.
     * It is intended to be used when there is a repetitive cleanup task that is performed by
     * several tests (e.g. deleting temp files, rolling back database transactions, etc) */
    @After
    public void teardown() {
        System.out.println("teardown");
    }

    /* Each test is implemented as a method with the @Test annotation. When the JUnit
     * framework is invoked, it looks for these @Test annotations on the test class
     * and runs such methods as tests.
     *
     * You will notice that the naming convention used in the test methods below
     * deviates from standard Java method naming conventions by using underscores
     * between words instead of camelCase. This is my own personal convention and
     * should not be construed as a general standard or convention. You can also
     * use camelCase for test method names. You should follow the norm at whatever
     * development organization you join.
     *
     * Regardless of whether you use camelCase or underscores, your method names
     * should be very descriptive to the point of being overly verbose. This is fine
     * because you will never write code to invoke your test methods, they are only
     * invoked by the Junit framework, hence descriptive trumps concise.
     *
     * Test methods always:
     *     - are public
     *     - return void
     *     - take no arguments
     */

    @Test
    public void ProvideKnownAnimalName_ExpectKnownHerdName() {
        // Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        // Act
        String herdName = animalGroup.getHerd("giraffe");

        // Assert
        assertEquals("Tower", herdName);
    }

    @Test
    public void ProvideKnowAnimalName_CrazyCase_ExpectKnownHerdName() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //Act
        String herdName = animalGroup.getHerd("GiRAffe");

        //Assert
        assertEquals("Tower", herdName);
    }

    @Test
    public void ProvideUnknownAnimalName_ExpectUnknownHerdName() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //Act
        String herdName = animalGroup.getHerd("");
        String herdName2 = animalGroup.getHerd("elephants");

        //Assert
        assertEquals("unknown", herdName);
        assertEquals("unknown", herdName2);
    }

    @Test
    public void ProvideNull_ExpectUnknownHerdName() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //Act
        String herdName = animalGroup.getHerd(null);

        //Assert
        assertEquals("unknown", herdName);
    }

}
