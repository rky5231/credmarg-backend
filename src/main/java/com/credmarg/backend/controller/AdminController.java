package com.credmarg.backend.controller;

import com.credmarg.backend.model.EmailLog;
import com.credmarg.backend.model.Employee;
import com.credmarg.backend.model.Vendor;
import com.credmarg.backend.service.EmailService;
import com.credmarg.backend.service.EmployeeService;
import com.credmarg.backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody Vendor vendor) {
        String message = String.format("Sending payments to vendor %s at upi %s", vendor.getName(), vendor.getUpi());
        emailService.sendEmail(vendor, message);
    }

    @GetMapping("/email-logs")
    public List<EmailLog> getAllEmailLogs() {
        return emailService.getAllEmailLogs();
    }
}
