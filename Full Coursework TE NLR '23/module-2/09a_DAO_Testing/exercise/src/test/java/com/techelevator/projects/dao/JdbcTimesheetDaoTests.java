package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        Timesheet expected = TIMESHEET_1;
        Timesheet actual = dao.getTimesheetById(expected.getTimesheetId());
        assertTimesheetsMatch(expected, actual);
    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {
        Timesheet actual = dao.getTimesheetById(3000);
        Assert.assertNull(actual);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        int employeeId = 1;
        List<Timesheet> actualTimesheets = dao.getTimesheetsByEmployeeId(employeeId);
        assertEquals(2, actualTimesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, actualTimesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, actualTimesheets.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        int projectId = 1;
        List<Timesheet> actualTimesheets = dao.getTimesheetsByProjectId(projectId);
        assertEquals(2, actualTimesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, actualTimesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_2, actualTimesheets.get(1));
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet newTimesheet = new Timesheet(5, 1, 2,
                LocalDate.parse("2022-01-01"), 1.5, true, "New Timesheet");
        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);
        Timesheet retrievedTimesheet = dao.getTimesheetById(createdTimesheet.getTimesheetId());
        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = TIMESHEET_1;
        timesheetToUpdate.setHoursWorked(2.0);
        dao.updateTimesheet(timesheetToUpdate);
        Timesheet updatedTimesheet = dao.getTimesheetById(timesheetToUpdate.getTimesheetId());
        assertTimesheetsMatch(timesheetToUpdate, updatedTimesheet);
    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        int timesheetId = TIMESHEET_4.getTimesheetId();
        dao.deleteTimesheetById(timesheetId);
        Timesheet deletedTimesheet = dao.getTimesheetById(timesheetId);
        Assert.assertNull(deletedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        int employeeId = 1;
        int projectId = 1;
        double expectedTotal = TIMESHEET_1.getHoursWorked() + TIMESHEET_2.getHoursWorked();
        double actualTotal = dao.getBillableHours(employeeId, projectId);
        Assert.assertEquals(expectedTotal, actualTotal, 0.001);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        assertEquals(expected.getProjectId(), actual.getProjectId());
        assertEquals(expected.getDateWorked(), actual.getDateWorked());
        assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        assertEquals(expected.isBillable(), actual.isBillable());
        assertEquals(expected.getDescription(), actual.getDescription());
    }
}
