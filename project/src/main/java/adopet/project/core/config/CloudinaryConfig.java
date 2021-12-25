package adopet.project.config;

import adopet.project.core.utilities.cloudinary.CloudinaryManager;
import adopet.project.core.utilities.cloudinary.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryAccount() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "adopet",
                "api_key", "443866898949355",
                "api_secret", "XCOKx_m4TAdFeyMfCHLztrZC_wQ"
        ));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryManager(cloudinaryAccount());
    }
}
