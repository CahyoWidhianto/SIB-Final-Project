package id.co.mii.LMS.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import id.co.mii.LMS.Model.Segment;
import id.co.mii.LMS.Service.SegmentService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SegmentController {
    private SegmentService segmentService;

    @GetMapping("/segments")
    public String getAllSegments(Model model, Authentication authentication) {
        List<Segment> segments = segmentService.getAll(authentication);
        model.addAttribute("segments", segments);
        return "segments";
    }
}
