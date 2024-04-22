import com.techelevator.exceptions.BankAccount;
import com.techelevator.exceptions.InsufficientFundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount("Homer", "123456", 100);
        account.deposit(-50);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFunds() throws InsufficientFundsException {
        BankAccount account = new BankAccount("Homer", "123456",100);
        account.withdraw(150);
    }

    @Test
    public void testWithdrawValidAmount() throws InsufficientFundsException {
        BankAccount account = new BankAccount("Homer", "123456",200);
        account.withdraw(150);
        assertEquals(50, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAccountWithNegativeBalance() {
        new BankAccount("Homer", "123456",-100);
    }
}