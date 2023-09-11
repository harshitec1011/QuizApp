package com.quiz.QuizApp.Controller;

import com.quiz.QuizApp.Model.Question;
import com.quiz.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

     @RequestMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
     // return "These are the all questions";
         return questionService.getAllQuestions();
    }
    @RequestMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
         return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

}
