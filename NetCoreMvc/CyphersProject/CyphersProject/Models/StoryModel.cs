using System;
using System.ComponentModel.DataAnnotations;

namespace NetCoreMvcApp.Models
{
    public class StoryModel
    {
        [Required]
        [StringLength(50)]
        [RegularExpression("^[a-zA-Z0-9_]*$", ErrorMessage = "僅允許英數字與底線")]
        public string chapter { get; set; }

        [Required]
        [Range(0, 999)]
        public int section { get; set; } = -1;

        [StringLength(5)]
        [RegularExpression("([0-9][0-9]_[0-9][0-9])", ErrorMessage = "格式應為99_99")]
        public string seq { get; set; }

        [StringLength(50)]
        public string title { get; set; }

        public string storyContent_ch { get; set; }

        public string storyContent_kr { get; set; }
        public string lastModified { get; set; }
    }
}
