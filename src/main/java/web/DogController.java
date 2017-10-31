package web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DogController {

    private Map<String, Dog> dogMap = new HashMap<String, Dog>();

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.GET)//{}로 입력값 처리 가능하게
    public Dog selectDogByName(@PathVariable String name) {
        log.info("Hey this is dog select controller!!!! {}", name);
        return dogMap.get(name);
    }

    @RequestMapping(value = "dogs", method = RequestMethod.POST)
    public void createDog(@RequestBody Dog dog) {
        dogMap.put(dog.getName(), dog);
    }

    @RequestMapping(value = "dogs/count", method = RequestMethod.GET)
    public int numberDog() {
        return dogMap.size();
    }

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.PUT)
    public Dog changeType(@PathVariable String name, @RequestParam String type) {
        Dog dog = dogMap.get(name);
        dog.setType(type);
        return dog;
    }

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.DELETE)
    public Dog removeDog(@PathVariable String name) {
        if (dogMap.containsKey(name)) {
            return dogMap.remove(name);
        }
        throw new RuntimeException("No Dog!!");
    }
}

