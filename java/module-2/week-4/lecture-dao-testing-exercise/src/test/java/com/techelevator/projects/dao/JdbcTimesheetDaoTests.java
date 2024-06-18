package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test  //lecture review
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheet = dao.getTimesheetById(1);
        Assert.assertNotNull("getTimeSheetById with valid id returned null timesheet.", timesheet);
        assertTimesheetsMatch("getTimesheetById with valid id returned the incorrect timesheet", TIMESHEET_1, timesheet);

        timesheet = dao.getTimesheetById(4);
        Assert.assertNotNull("getTimeSheetById with valid id returned null timesheet.", timesheet);
        assertTimesheetsMatch("getTimesheetById with valid id returned the incorrect timesheet", TIMESHEET_4, timesheet);
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Assert.fail();
    }

    @Test //lecture review
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);
        assertNotNull("getTimesheetsByEmployeeId with valid employee id returned null list of timesheets", timesheets);
        Assert.assertEquals("getTimesheetsByEmployeeId with valid employee id returned incorrect number of timesheets in the list.", 2, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned returned incorrect timesheet", TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned returned incorrect timesheet", TIMESHEET_2, timesheets.get(1));

        timesheets = dao.getTimesheetsByEmployeeId(2);
        assertNotNull("getTimesheetsByEmployeeId with valid employee id returned null list of timesheets", timesheets);
        Assert.assertEquals("getTimesheetsByEmployeeId with valid employee id returned incorrect number of timesheets in the list.", 2, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned returned incorrect timesheet", TIMESHEET_3, timesheets.get(0));
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned returned incorrect timesheet", TIMESHEET_4, timesheets.get(1));

    }

    @Test
    public void getTimesheetsByEmployeeId_with_invalid_employee_id_returns_empty_list_of_timesheets() {
        Assert.fail();
    }

    @Test
    public void getTimesheetsByProjectId_with_valid_project_id_returns_list_of_all_timesheets_for_project() {
        Assert.fail();
    }

    @Test
    public void getTimesheetsByProjectId_with_invalid_project_id_returns_empty_list_of_timesheets() {
        Assert.fail();
    }

    @Test //lecture review
    public void createTimesheet_creates_timesheet() {
        Assert.fail();
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Assert.fail();
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        Assert.fail();
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Assert.fail();
    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }

}
