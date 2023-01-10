package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Todomodel;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

/*    1	todo 리스트 목록에 아이템을 추가
2	todo  리스트 목록 중 특정 아이템을 조회
3	todo 리스트 전체 목록을 조회
4	todo 리스트 목록 중 특정 아이템을 수정
5	todo 리스트 목록 중 특정 아이템을 삭제
6	todo 리스트 전체 목록을 삭제
 */

    public Todomodel add(TodoRequest request){
        Todomodel todomodel = new Todomodel();
        todomodel.setTitle(request.getTitle());
        todomodel.setOrder(request.getOrder());
        todomodel.setCompleted(request.getCompleted());
        return  this.todoRepository.save(todomodel);

    }
    public Todomodel searchById(Long id){
       return  this.todoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    public List<Todomodel> searchAll(){
       return this.todoRepository.findAll();

    }
    public Todomodel updateById(Long id, TodoRequest request){
       Todomodel todomodel = this.searchById(id);
       if(request.getTitle()!=null){
           todomodel.setTitle(request.getTitle());
       }if(request.getOrder()!=null){
           todomodel.setOrder(request.getOrder());
       }if(request.getCompleted()!=null){
           todomodel.setCompleted(request.getCompleted());
       }
       return this.todoRepository.save(todomodel);
    }
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
