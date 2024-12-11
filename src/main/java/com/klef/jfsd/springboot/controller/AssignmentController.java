package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.jfsd.springboot.model.Assignment;
import com.klef.jfsd.springboot.service.AssignmentService;  // Ensure correct import
import java.util.List;

@RestController
@RequestMapping("/assignments")
@CrossOrigin(origins = "http://localhost:3000")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Fetch all assignments (projects)
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    // Create a new assignment (project)
    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        try {
            Assignment createdAssignment = assignmentService.createAssignment(assignment);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Delete an assignment (project)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        try {
            assignmentService.deleteAssignment(id);
            return ResponseEntity.ok("Assignment (project) deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to delete project: " + e.getMessage());
        }
    }
}
