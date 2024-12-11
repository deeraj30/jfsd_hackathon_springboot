package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.jfsd.springboot.model.Assignment;
import com.klef.jfsd.springboot.repository.AssignmentRepository;
import java.util.List;

@Service  // Ensure this is in the service package
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    // Fetch all assignments (projects)
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    // Create a new assignment (project)
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Delete an assignment (project)
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
