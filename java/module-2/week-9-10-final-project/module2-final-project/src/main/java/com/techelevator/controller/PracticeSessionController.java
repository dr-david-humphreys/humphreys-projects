package com.techelevator.controller;

import com.techelevator.dao.PracticeSessionDao;
import com.techelevator.model.PracticeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/practice_session")
public class PracticeSessionController {

    @Autowired
    private PracticeSessionDao practiceSessionDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PracticeSession logPracticeSession(@RequestBody PracticeSession practiceSession, Authentication authentication) {
        try {
            String username = authentication.getName();
            practiceSession.setUsername(username);
            return practiceSessionDao.createPracticeSession(practiceSession);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error logging practice session - " + e.getMessage());
        }
    }

    @GetMapping
    public List<PracticeSession> getAllPracticeSessions(Authentication authentication) {
        try {
            String username = authentication.getName();
            return practiceSessionDao.getPracticeSessionsByUsername(username);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting practice sessions - " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public PracticeSession updatePracticeSession(@PathVariable int id, @RequestBody PracticeSession practiceSession, Authentication authentication) {
        try {
            String username = authentication.getName();
            practiceSession.setUsername(username);
            practiceSession.setPracticeSessionId(id);
            return practiceSessionDao.updatePracticeSession(practiceSession);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating practice session - " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePracticeSession(@PathVariable int id, Authentication authentication) {
        try {
            String username = authentication.getName();
            practiceSessionDao.deletePracticeSessionById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting practice session - " + e.getMessage());
        }
    }
}
