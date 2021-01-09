
## Todays Snippets :+1:

## POM.XML
```
<dependency>
    <groupId>javax.ws.rs</groupId>
    <artifactId>javax.ws.rs-api</artifactId>
    <version>2.0.1</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.4</version>
</dependency> 
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.9.4</version>
</dependency>
```

## AgentRestController.java
```
import java.util.List;
import lit.sd4.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentRestController {
    
    @Autowired
    AgentService service;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Agent a) {
        service.editAnAgent(id, a);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Agent a) {
        return service.addAnAgent(a);
    }
    
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteAnAgent(id);
    }  
    
    @GetMapping("/{id}")
    public Agent getAgent(@PathVariable("id") int id) {
        return service.find(id);
    }

    @GetMapping(value = "/hateoas", produces = MediaTypes.HAL_JSON_VALUE)
    public Resources<Agent> getAgentsWithHATEOAS() {
        List<Agent> allAgents = service.getAllAgents();

        for (Agent a : allAgents) {

            int agentId = a.getAgentID();
            Link selfLink = linkTo(this.getClass()).slash(agentId).withSelfRel();
            a.add(selfLink);
            linkTo(methodOn(this.getClass()).getAgent(agentId));

        }
        Link link = linkTo(this.getClass()).withSelfRel();
        Resources<Agent> result = new Resources<Agent>(allAgents, link);
        return result;
    }

    @GetMapping (value="/hateoas/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public Resource<Agent> retrieveAgent(@PathVariable("id") int id) {
        Resource<Agent> resource = new Resource<Agent>(service.find(id));

       
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAgents());

        resource.add(linkTo.withRel("all-agents"));

        return resource;
    }
    


    @GetMapping
    public List<Agent> getAgents() {
        return service.getAllAgents();
    } 
   
}
