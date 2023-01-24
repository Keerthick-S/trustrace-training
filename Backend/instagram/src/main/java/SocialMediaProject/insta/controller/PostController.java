package SocialMediaProject.insta.controller;

import SocialMediaProject.insta.pojo.Post;
import SocialMediaProject.insta.service.PostService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/{instaId}")
    public String createPost(@PathVariable("instaId") String userId, @RequestBody Post post) {
        postService.createPost(userId, post);
        return "Post Uploaded Successfully";
    }
    @GetMapping("/{instaId}")
    public List<Post> userAllPost(@PathVariable("instaId") String instaId) {
        return postService.userAllPost(instaId);
    }

    @GetMapping("/all-post")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
    @DeleteMapping("/{instaId}/{id}")
    public String deletePost(@PathVariable("instaId") String instaId,@PathVariable("id") String id) {
        postService.deletePost(instaId, id);
        return "Deleted Successfully";
    }
    @GetMapping("/{instaId}/{id}")
    public Post getPost(@PathVariable("instaId") String instaId, @PathVariable("id") String id) {
        return postService.getPost(id, instaId);
    }
    @GetMapping
    public List<Post> getTopPost(@PathParam("page") int page, @PathParam("limit") int limit) {
        return postService.getTopPost(page, limit);
    }
}
