package com.example.LocationAPI.LocationAPI;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/users/{username}/locations")
    public List<Location> getAllLocations(@PathVariable String username){
        return locationService.findAll();
    }

    @DeleteMapping("/users/{username}/locations/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String username,@PathVariable long id){
        Location location = locationService.deleteById(id);
        if (location!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/locations/{id}")
    public Location getLocation(@PathVariable String username, @PathVariable long id){
        return locationService.findById(id);
    }

    @PutMapping("/users/{username}/locations/{id}")
    public ResponseEntity<Location> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Location location){
        Location locationUpdate = locationService.save(location);
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/locations")
    public ResponseEntity<Void> updateLocation(@PathVariable String username,@RequestBody Location location
    ) {
        Location createLocation = locationService.save(location);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createLocation.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "locations/{id}/upload", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file")MultipartFile file, @PathVariable String id ) throws IOException {
        File convertFile = new File(
                "E:\\Location_app\\Location-API\\src\\main\\java\\com\\example\\LocationAPI\\LocationAPI\\LocationPictures" + file.getOriginalFilename());
        convertFile.createNewFile();
        try (FileOutputStream fout = new FileOutputStream(convertFile)){
            fout.write(file.getBytes());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "File has uploaded successfully";
    }

}
