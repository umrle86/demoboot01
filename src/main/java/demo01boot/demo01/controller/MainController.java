package demo01boot.demo01.controller;

import demo01boot.demo01.service.GameParamsService;
import demo01boot.demo01.vo.Result;
import demo01boot.demo01.vo.params.GamePojoParams;
import demo01boot.demo01.vo.params.PageParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author name
 * @version 1.0
 */
@RequestMapping
@RestController
public class MainController {
    @Resource
    GameParamsService gameParamsService;

    @GetMapping()
    public String test(){
        return  "redirect:/index.html";
    }

    @PostMapping("selectAll")
    public Result  selectAll(@RequestBody PageParams params){
        return gameParamsService.getListGame(params);
    }

    @PutMapping("put")
    public Result saveData(@RequestBody GamePojoParams pojoParams){
     return gameParamsService.saveGameParamsData(pojoParams);
    }
    @PostMapping("update")
    public Result updateData(@RequestBody GamePojoParams pojoParams){
        return gameParamsService.updateGameData(pojoParams);
    }
    @DeleteMapping("delete/{gameId}")
    public Result deleteData(@PathVariable("gameId") Long id){
        return  gameParamsService.deleteByGameId(id);
    }
}
