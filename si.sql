-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2023 at 08:20 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `si`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `speciality` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `doctor_desc` text NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `user_name`, `password`, `name`, `age`, `speciality`, `phone`, `doctor_desc`, `email`) VALUES
(2, 'bilel', 'test', 'Bilel', 50, 'Cardiologist', '0558966521', 'Best in town', 'bilel@gmail.com'),
(9, 'orthosurgeon', 'test', 'John Smith', 45, 'Orthopedic Surgeon', '0551234567', 'Experienced orthopedic surgeon specializing in joint replacements.', 'john.smith@example.com'),
(10, 'dermadoctor', 'test', 'Emily Johnson', 35, 'Dermatologist', '0559876543', 'Dermatology expert with a focus on skin conditions and treatments.', 'emily.johnson@example.com'),
(11, 'pediatricsdoc', 'test', 'Sarah Wilson', 42, 'Pediatrician', '0556543210', 'Compassionate pediatrician dedicated to providing quality care for children.', 'sarah.wilson@example.com'),
(12, 'neurologist1', 'test', 'Michael Anderson', 48, 'Neurologist', '0557890123', 'Expert neurologist specializing in the diagnosis and treatment of neurological disorders.', 'michael.anderson@example.com'),
(13, 'opthalmologist', 'test', 'Jessica Lee', 39, 'Ophthalmologist', '0554567890', 'Skilled ophthalmologist providing comprehensive eye care services.', 'jessica.lee@example.com'),
(14, 'dentist123', 'test', 'David Johnson', 37, 'Dentist', '0555678901', 'Experienced dentist offering a wide range of dental treatments and services.', 'david.johnson@example.com'),
(15, 'psychiatrydoc', 'test', 'Olivia Davis', 41, 'Psychiatrist', '0556789012', 'Compassionate psychiatrist specializing in mental health and well-being.', 'olivia.davis@example.com'),
(16, 'entdoctor', 'test', 'Ethan Wilson', 44, 'ENT Specialist', '0557890123', 'ENT specialist providing diagnosis and treatment for ear, nose, and throat conditions.', 'ethan.wilson@example.com'),
(17, 'gynecologist', 'test', 'Sophia Martinez', 36, 'Gynecologist', '0558901234', 'Experienced gynecologist offering comprehensive women\'s health services.', 'sophia.martinez@example.com'),
(18, 'urologist1', 'test', 'Daniel Thompson', 47, 'Urologist', '0559012345', 'Skilled urologist specializing in the diagnosis and treatment of urinary tract disorders.', 'daniel.thompson@example.com'),
(19, 'orthodontist', 'test', 'Mia Roberts', 38, 'Orthodontist', '0550123456', 'Orthodontic specialist providing braces and orthodontic treatments for all ages.', 'mia.roberts@example.com'),
(20, 'allergistdoc', 'test', 'Benjamin Harris', 43, 'Allergist', '0551234567', 'Allergy specialist offering diagnosis and treatment for allergic conditions.', 'benjamin.harris@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `help`
--

CREATE TABLE `help` (
  `illness_id` int(11) NOT NULL,
  `treatment_ar` text NOT NULL,
  `treatment_en` text NOT NULL,
  `treatment_fr` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `help`
--

INSERT INTO `help` (`illness_id`, `treatment_ar`, `treatment_en`, `treatment_fr`) VALUES
(1, 'تحاول تجنب الشيء الذي لديك حساسية منه كلما أمكن ذلك\r\nأدوية لتفاعلات الحساسية الخفيفة مثل مضادات الهيستامين وأقراص الستيرويد وكريمات الستيرويد\r\nأدوية الطوارئ تسمى حاقن الأدرينالين التلقائي ، مثل EpiPen ، لردود الفعل التحسسية الشديدة\r\nإزالة التحسس (العلاج المناعي) لردود الفعل التحسسية الشديدة - يتضمن ذلك تعريضك بعناية للشيء الذي لديك حساسية تجاهه بمرور الوقت ، لذلك يعتاد جسمك عليه تدريجيًا ولا يتفاعل بشكل سيء (يجب أن يتم ذلك بواسطة طبيب متخصص فقط)', 'trying to avoid the thing you\'re allergic to whenever possible\r\nmedicines for mild allergic reactions like antihistamines, steroid tablets and steroid creams\r\nemergency medicines called adrenaline auto-injectors, such as an EpiPen, for severe allergic reactions\r\ndesensitisation (immunotherapy) for severe allergic reactions – this involves carefully exposing you to the thing you\'re allergic to over time, so your body gradually gets used to it and does not react so badly (this should only be done by a medical professional)', 'essayer d\'éviter les choses auxquelles vous êtes allergique autant que possible\nmédicaments pour les réactions allergiques légères comme les antihistaminiques, les comprimés de stéroïdes et les crèmes stéroïdes\nmédicaments d\'urgence appelés auto-injecteurs d\'adrénaline, comme un EpiPen, pour les réactions allergiques graves\ndésensibilisation (immunothérapie) pour les réactions allergiques graves - cela implique de vous exposer soigneusement à la chose à laquelle vous êtes allergique au fil du temps, afin que votre corps s\'y habitue progressivement et ne réagisse pas si mal (cela ne devrait être fait que par un professionnel de la santé)'),
(2, 'الراحة والنوم.\r\nشرب الكثير من الماء (عصير الفاكهة أو القرع الممزوج بالماء لا بأس به) لتجنب الجفاف.\r\nالغرغرة بالماء المالح لتسكين التهاب الحلق (غير مناسب للأطفال)', 'rest and sleep.\r\ndrink plenty of water (fruit juice or squash mixed with water is OK) to avoid dehydration.\r\ngargle salt water to soothe a sore throat (not suitable for children)', 'repos et sommeil.\r\nbuvez beaucoup d\'eau (du jus de fruit ou de la courge mélangée à de l\'eau est OK) pour éviter la déshydratation.\r\nse gargariser d\'eau salée pour apaiser un mal de gorge (ne convient pas aux enfants)'),
(3, 'إذا كنت تعاني من صعوبة شديدة في التنفس ، فستحتاج إلى رعاية طبية.\r\nعدا ذلك ، ابق في المنزل لمدة 5 أيام على الأقل وانعزل عن الآخرين في منزلك. من المحتمل أن تكون أكثر عدوى خلال هذه الأيام الخمسة الأولى. ارتدِ قناعًا عالي الجودة إذا كان يجب أن تكون بالقرب من الآخرين في المنزل وفي الأماكن العامة. لا تذهب إلى الأماكن التي لا يمكنك فيها ارتداء الكمامة.', 'If you have a sever difficulty breathing you are going to need medical attention.\r\nElse,stay home for at least 5 days and isolate from others in your home. You are likely most infectious during these first 5 days. Wear a high-quality mask if you must be around others at home and in public. Do not go places where you are unable to wear a mask.', 'Si vous avez de graves difficultés respiratoires, vous aurez besoin de soins médicaux.\r\nSinon, restez à la maison pendant au moins 5 jours et isolez-vous des autres dans votre maison. Vous êtes probablement le plus contagieux au cours de ces 5 premiers jours. Portez un masque de haute qualité si vous devez être entouré d\'autres personnes à la maison et en public. Ne vous rendez pas dans des endroits où vous ne pouvez pas porter de masque.'),
(4, 'الراحة قدر الإمكان.\r\nتناول الطعام عندما تشعر بالقدرة على ذلك - الالتزام بوجبات صغيرة وخفيفة وغير دهنية في البداية (الأطعمة الخفيفة مثل الخبز المحمص والبسكويت والأرز والموز خيارات جيدة)\r\nتجنب الكحول والكافيين والمشروبات الغازية والأطعمة الحارة والدهنية لأنها قد تجعلك تشعر بسوء.', 'rest as much as possible.\r\neat when you feel up to it – sticking to small, light and non-fatty meals at first (bland foods such as toast, crackers, rice and bananas are good choices)\r\navoid alcohol, caffeine, fizzy drinks and spicy and fatty foods because they may make you feel worse.', 'reposez-vous le plus possible.\r\nMangez quand vous vous sentez à la hauteur - tenez-vous-en à de petits repas légers et non gras au début (les aliments fades comme les rôties, les craquelins, le riz et les bananes sont de bons choix)\r\névitez l\'alcool, la caféine, les boissons gazeuses et les aliments épicés et gras, car ils peuvent aggraver votre état de santé.'),
(5, 'الراحة: احصل على قسط كبير من الراحة للسماح لجسمك بالتعافي والشفاء.\r\n\r\nحافظ على رطوبتك: اشرب الكثير من السوائل ، مثل الماء وشاي الأعشاب والمرق الصافي للبقاء رطبًا ومساعدة المخاط الرقيق.\r\n\r\nالأدوية التي لا تستلزم وصفة طبية: يمكن للأدوية بدون وصفة طبية ، مثل مسكنات الألم (مثل الأسيتامينوفين) ومزيلات الاحتقان ومثبطات السعال ، أن توفر راحة مؤقتة من الأعراض. ومع ذلك ، من المهم اتباع التعليمات واستشارة أخصائي الرعاية الصحية إذا كنت تعاني من أي حالات صحية أساسية أو كنت تتناول أدوية أخرى.', 'Rest: Get plenty of rest to allow your body to recover and heal.\r\n\r\nStay hydrated: Drink plenty of fluids, such as water, herbal tea, and clear broths, to stay hydrated and help thin mucus.\r\n\r\nOver-the-counter medications: Non-prescription medications, such as pain relievers (e.g., acetaminophen), decongestants, and cough suppressants, can provide temporary relief from symptoms. However, it\'s important to follow the instructions and consult a healthcare professional if you have any underlying health conditions or are taking other medications.', 'Reposez-vous : reposez-vous suffisamment pour permettre à votre corps de récupérer et de guérir.\r\n\r\nRestez hydraté : buvez beaucoup de liquides, comme de l\'eau, des tisanes et des bouillons clairs, pour rester hydraté et aider à fluidifier le mucus.\r\n\r\nMédicaments en vente libre : Les médicaments en vente libre, tels que les analgésiques (par exemple, l\'acétaminophène), les décongestionnants et les antitussifs, peuvent procurer un soulagement temporaire des symptômes. Cependant, il est important de suivre les instructions et de consulter un professionnel de la santé si vous avez des problèmes de santé sous-jacents ou si vous prenez d\'autres médicaments.'),
(6, 'تجنب المواد المسببة للحساسية: قلل من تعرضك لمسببات الحساسية عن طريق البقاء في المنزل في الأيام التي ترتفع فيها نسبة حبوب اللقاح ، وإبقاء النوافذ مغلقة ، واستخدام أجهزة تنقية الهواء مع مرشحات HEPA ، وتجنب الأنشطة التي قد تعرضك لمسببات الحساسية.\r\n\r\nالأدوية:\r\n\r\nمضادات الهيستامين: تعمل هذه الأدوية على منع عمل الهيستامين ، وهو مادة كيميائية يتم إطلاقها أثناء تفاعل الحساسية. يمكن أن تساعد في تخفيف العطس والحكة وسيلان الأنف والعيون الدامعة. مضادات الهيستامين متاحة بدون وصفة طبية (على سبيل المثال ، لوراتادين ، سيتريزين) أو بوصفة طبية.', 'Avoid allergens: Limit your exposure to allergens by staying indoors on high pollen days, keeping windows closed, using air purifiers with HEPA filters, and avoiding activities that may expose you to allergens.\r\n\r\nMedications:\r\n\r\nAntihistamines: These medications block the action of histamine, a chemical released during an allergic reaction. They can help relieve sneezing, itching, runny nose, and watery eyes. Antihistamines are available over-the-counter (e.g., loratadine, cetirizine) or by prescription.', 'Évitez les allergènes : Limitez votre exposition aux allergènes en restant à l\'intérieur les jours où le pollen est élevé, en gardant les fenêtres fermées, en utilisant des purificateurs d\'air avec des filtres HEPA et en évitant les activités qui pourraient vous exposer aux allergènes.\r\n\r\nMédicaments :\r\n\r\nAntihistaminiques : Ces médicaments bloquent l\'action de l\'histamine, une substance chimique libérée lors d\'une réaction allergique. Ils peuvent aider à soulager les éternuements, les démangeaisons, le nez qui coule et les yeux larmoyants. Les antihistaminiques sont disponibles en vente libre (par exemple, la loratadine, la cétirizine) ou sur ordonnance.'),
(7, 'المضادات الحيوية: المضادات الحيوية الأكثر شيوعًا التي يتم وصفها لالتهاب الحلق هي البنسلين أو الأموكسيسيلين. يمكن وصف البدائل الأخرى ، مثل السيفالوسبورينات أو الماكروليدات ، إذا كنت تعاني من حساسية تجاه البنسلين. من الضروري إكمال الدورة التدريبية الكاملة للمضادات الحيوية كما هو موصوف ، حتى لو تحسنت الأعراض ، لضمان القضاء على العدوى تمامًا.\r\n\r\nتخفيف الآلام: يمكن أن تساعد مسكنات الألم التي لا تستلزم وصفة طبية مثل عقار الاسيتامينوفين (تايلينول) أو مضادات الالتهاب غير الستيرويدية (المسكنات) مثل الإيبوبروفين (أدفيل وموترين) في تخفيف آلام الحلق وتقليل الحمى. اتبع التعليمات واستشر أخصائي الرعاية الصحية للجرعة المناسبة.\r\n\r\nالراحة والترطيب: الحصول على قسط كبير من الراحة يسمح لجسمك بالتعافي بشكل أكثر فعالية. من الضروري أيضًا أن تحافظ على رطوبتك عن طريق شرب الكثير من السوائل مثل الماء أو الشاي الدافئ أو المرق الصافي لتهدئة حلقك ومنع الجفاف.', 'Antibiotics: The most commonly prescribed antibiotics for strep throat are penicillin or amoxicillin. Other alternatives, such as cephalosporins or macrolides, may be prescribed if you are allergic to penicillin. It\'s essential to complete the entire course of antibiotics as prescribed, even if symptoms improve, to ensure the infection is fully eradicated.\r\n\r\nPain relief: Over-the-counter pain relievers like acetaminophen (Tylenol) or nonsteroidal anti-inflammatory drugs (NSAIDs) such as ibuprofen (Advil, Motrin) can help alleviate throat pain and reduce fever. Follow the instructions and consult a healthcare professional for appropriate dosage.\r\n\r\nRest and hydration: Getting plenty of rest allows your body to recover more effectively. It\'s also crucial to stay hydrated by drinking plenty of fluids such as water, warm tea, or clear broth to soothe your throat and prevent dehydration.', 'Antibiotiques : Les antibiotiques les plus couramment prescrits pour l\'angine streptococcique sont la pénicilline ou l\'amoxicilline. D\'autres alternatives, comme les céphalosporines ou les macrolides, peuvent vous être prescrites si vous êtes allergique à la pénicilline. Il est essentiel de suivre la totalité du traitement antibiotique prescrit, même si les symptômes s\'améliorent, pour s\'assurer que l\'infection est complètement éradiquée.\r\n\r\nSoulagement de la douleur : Les analgésiques en vente libre comme l\'acétaminophène (Tylenol) ou les anti-inflammatoires non stéroïdiens (AINS) comme l\'ibuprofène (Advil, Motrin) peuvent aider à soulager les maux de gorge et à réduire la fièvre. Suivez les instructions et consultez un professionnel de la santé pour connaître la posologie appropriée.\r\n\r\nRepos et hydratation : se reposer suffisamment permet à votre corps de récupérer plus efficacement. Il est également crucial de rester hydraté en buvant beaucoup de liquides tels que de l\'eau, du thé chaud ou du bouillon clair pour apaiser votre gorge et prévenir la déshydratation.'),
(8, 'تطبيق الحرارة الرطبة: يمكن أن يساعد تطبيق الحرارة الرطبة على وجهك ، مثل الضغط الدافئ أو استنشاق البخار ، في تهدئة آلام الجيوب الأنفية وتعزيز تصريف الجيوب الأنفية.\r\n\r\nالترطيب: اشرب الكثير من السوائل ، مثل الماء وشاي الأعشاب والمرق الصافي للبقاء رطبًا ومساعدة المخاط الرقيق ، مما يسهل تصريفه من الجيوب الأنفية.\r\n\r\nوصفات الأدوية:\r\n\r\nالمضادات الحيوية: إذا كان التهاب الجيوب الأنفية ناتجًا عن عدوى بكتيرية أو إذا كانت الأعراض شديدة وطويلة الأمد ، فقد يصف أخصائي الرعاية الصحية المضادات الحيوية. من المهم إكمال الدورة التدريبية الكاملة للمضادات الحيوية على النحو الموصوف.\r\n\r\nالستيرويدات القشرية: يمكن أن تساعد بخاخات الكورتيكوستيرويد الأنفية في تقليل الالتهاب في الممرات الأنفية والجيوب الأنفية ، وتعزيز التصريف وتخفيف الأعراض. قد تكون هذه الأدوية متاحة بدون وصفة طبية أو بوصفة طبية.', 'Moist heat application: Applying moist heat to your face, such as with a warm compress or a steam inhalation, can help soothe sinus pain and promote sinus drainage.\r\n\r\nHydration: Drink plenty of fluids, such as water, herbal tea, and clear broths, to stay hydrated and help thin mucus, making it easier to drain from the sinuses.\r\n\r\nPrescription medications:\r\n\r\nAntibiotics: If sinusitis is caused by a bacterial infection or if symptoms are severe and prolonged, a healthcare professional may prescribe antibiotics. It\'s important to complete the entire course of antibiotics as prescribed.\r\n\r\nCorticosteroids: Nasal corticosteroid sprays can help reduce inflammation in the nasal passages and sinuses, promoting drainage and relieving symptoms. These may be available over-the-counter or by prescription.', 'Application de chaleur humide : L\'application de chaleur humide sur votre visage, par exemple avec une compresse chaude ou une inhalation de vapeur, peut aider à apaiser la douleur des sinus et favoriser le drainage des sinus.\r\n\r\nHydratation : buvez beaucoup de liquides, tels que de l\'eau, des tisanes et des bouillons clairs, pour rester hydraté et aider à fluidifier le mucus, ce qui facilite le drainage des sinus.\r\n\r\nMédicaments sur ordonnance :\r\n\r\nAntibiotiques : Si la sinusite est causée par une infection bactérienne ou si les symptômes sont graves et prolongés, un professionnel de la santé peut prescrire des antibiotiques. Il est important de suivre la totalité du traitement antibiotique tel que prescrit.\r\n\r\nCorticostéroïdes : les vaporisateurs nasaux de corticostéroïdes peuvent aider à réduire l\'inflammation des voies nasales et des sinus, en favorisant le drainage et en soulageant les symptômes. Ceux-ci peuvent être disponibles en vente libre ou sur ordonnance.'),
(9, 'مسكنات الألم التي لا تستلزم وصفة طبية: يمكن أن تكون مضادات الالتهاب غير الستيرويدية (NSAIDs) مثل الأيبوبروفين أو نابروكسين الصوديوم فعالة في حالات الصداع النصفي الخفيف إلى المتوسط.\r\n\r\nأدوية التريبتان: هذه الأدوية الموصوفة ، مثل سوماتريبتان أو ريزاتريبتان ، مخصصة لعلاج الصداع النصفي وتعمل عن طريق تقييد الأوعية الدموية وسد مسارات الألم في الدماغ.\r\n\r\nالمسكنات: قد تكون بعض المسكنات ، مثل عقار الاسيتامينوفين مع الكافيين ، فعالة لبعض الأفراد.\r\n\r\nالأدوية المضادة للغثيان: إذا تسبب الصداع النصفي في غثيان شديد أو قيء ، فيمكن وصف الأدوية المضادة للغثيان مثل ميتوكلوبراميد أو بروكلوربيرازين.\r\n\r\nالأدوية: بالنسبة للأفراد الذين يعانون من الصداع النصفي المتكرر أو الشديد ، يمكن وصف الأدوية الوقائية. يمكن أن تشمل هذه الأدوية حاصرات بيتا ، ومضادات الاكتئاب ، وأدوية الصرع ، أو بعض أدوية ضغط الدم.', 'Over-the-counter pain relievers: Nonsteroidal anti-inflammatory drugs (NSAIDs) like ibuprofen or naproxen sodium can be effective for mild to moderate migraines.\r\n\r\nTriptans: These prescription medications, such as sumatriptan or rizatriptan, are specific to treating migraines and work by constricting blood vessels and blocking pain pathways in the brain.\r\n\r\nAnalgesics: Certain analgesics, such as acetaminophen combined with caffeine, may be effective for some individuals.\r\n\r\nAnti-nausea medications: If migraines cause severe nausea or vomiting, anti-nausea medications like metoclopramide or prochlorperazine may be prescribed.\r\n\r\nPreventive treatment:\r\nMedications: For individuals with frequent or severe migraines, preventive medications may be prescribed. These can include beta-blockers, antidepressants, antiepileptic drugs, or certain blood pressure medications.', 'Analgésiques en vente libre : Les anti-inflammatoires non stéroïdiens (AINS) comme l\'ibuprofène ou le naproxène sodique peuvent être efficaces pour les migraines légères à modérées.\r\n\r\nTriptans : Ces médicaments sur ordonnance, tels que le sumatriptan ou le rizatriptan, sont spécifiques au traitement des migraines et agissent en resserrant les vaisseaux sanguins et en bloquant les voies de la douleur dans le cerveau.\r\n\r\nAnalgésiques : certains analgésiques, comme l\'acétaminophène combiné à la caféine, peuvent être efficaces chez certaines personnes.\r\n\r\nMédicaments anti-nausées : Si les migraines provoquent des nausées ou des vomissements sévères, des médicaments anti-nausées comme le métoclopramide ou la prochlorpérazine peuvent être prescrits.\r\n\r\nMédicaments : Pour les personnes souffrant de migraines fréquentes ou sévères, des médicaments préventifs peuvent être prescrits. Ceux-ci peuvent inclure des bêta-bloquants, des antidépresseurs, des médicaments antiépileptiques ou certains médicaments contre l\'hypertension.'),
(10, 'التغييرات في النظام الغذائي: تجنب الأطعمة والمشروبات التي قد تؤدي إلى تفاقم أعراض الارتجاع ، مثل الأطعمة الدهنية أو المقلية والفواكه الحمضية والأطعمة الحارة والكافيين والكحول والمشروبات الغازية. يمكن أن يساعد أيضًا تناول وجبات صغيرة ومتكررة.\r\n\r\nإدارة الوزن: يمكن أن يؤدي الوصول إلى وزن صحي والحفاظ عليه إلى تقليل الضغط على المعدة وتقليل الأعراض.\r\n\r\nرفع رأس السرير: يمكن أن يساعد رفع رأس السرير باستخدام كتل أو وسادة إسفينية في منع ارتداد الحمض أثناء النوم.\r\n\r\nتجنب الاستلقاء بعد الوجبات: انتظر ما لا يقل عن ساعتين إلى ثلاث ساعات قبل الاستلقاء أو الذهاب إلى الفراش بعد تناول الطعام.\r\n\r\nمضادات الحموضة: يمكن أن توفر راحة مؤقتة عن طريق تحييد حمض المعدة. إنها مفيدة للأعراض الخفيفة والعرضية.', 'Dietary changes: Avoid trigger foods and beverages that can worsen reflux symptoms, such as fatty or fried foods, citrus fruits, spicy foods, caffeine, alcohol, and carbonated drinks. Eating smaller, more frequent meals can also help.\r\n\r\nWeight management: Achieving and maintaining a healthy weight can reduce the pressure on the stomach and decrease symptoms.\r\n\r\nElevating the head of the bed: Raising the head of the bed by using blocks or a wedge pillow can help prevent acid reflux during sleep.\r\n\r\nAvoiding lying down after meals: Wait at least two to three hours before lying down or going to bed after eating.\r\n\r\nAntacids: These can provide temporary relief by neutralizing stomach acid. They are useful for mild and occasional symptoms.', 'Changements alimentaires : évitez les aliments et les boissons déclencheurs qui peuvent aggraver les symptômes de reflux, tels que les aliments gras ou frits, les agrumes, les aliments épicés, la caféine, l\'alcool et les boissons gazeuses. Manger des repas plus petits et plus fréquents peut également aider.\r\n\r\nGestion du poids : Atteindre et maintenir un poids santé peut réduire la pression sur l\'estomac et diminuer les symptômes.\r\n\r\nÉlever la tête du lit : Élever la tête du lit à l\'aide de blocs ou d\'un oreiller en coin peut aider à prévenir le reflux acide pendant le sommeil.\r\n\r\nÉviter de s\'allonger après les repas : Attendez au moins deux à trois heures avant de vous allonger ou de vous coucher après avoir mangé.\r\n\r\nAntiacides : Ceux-ci peuvent apporter un soulagement temporaire en neutralisant l\'acide gastrique. Ils sont utiles pour les symptômes légers et occasionnels.'),
(11, 'ابق في الداخل عندما تكون أعداد حبوب اللقاح عالية ، خاصة في الأيام العاصفة.\r\nحافظ على النوافذ مغلقة لمنع حبوب اللقاح من دخول منزلك.\r\nاستخدم أجهزة تنقية الهواء مع مرشحات HEPA لتقليل مسببات الحساسية في الداخل.\r\nتجنب الأنشطة الخارجية التي قد تعرضك لمسببات الحساسية ، خاصة خلال أوقات ذروة حبوب اللقاح.\r\nاغسل يديك ووجهك بعد الخروج من المنزل لإزالة حبوب اللقاح من بشرتك وشعرك.\r\nضع في اعتبارك ارتداء النظارات الشمسية لحماية عينيك من حبوب اللقاح.\r\n\r\nمضادات الهيستامين: يمكن أن تساعد مضادات الهيستامين التي لا تستلزم وصفة طبية مثل اللوراتادين أو السيتريزين أو الفكسوفينادين في تخفيف الأعراض مثل العطس والحكة وسيلان الأنف وحكة / عيون دامعة. وهي متوفرة في شكل أقراص أو سائل أو رذاذ أنفي.', 'Stay indoors when pollen counts are high, especially on windy days.\r\nKeep windows closed to prevent pollen from entering your home.\r\nUse air purifiers with HEPA filters to reduce allergens indoors.\r\nAvoid outdoor activities that may expose you to allergens, particularly during peak pollen times.\r\nWash your hands and face after being outdoors to remove pollen from your skin and hair.\r\nConsider wearing sunglasses to protect your eyes from pollen.\r\n\r\nAntihistamines: Over-the-counter antihistamines like loratadine, cetirizine, or fexofenadine can help relieve symptoms such as sneezing, itching, runny nose, and itchy/watery eyes. They are available in tablet, liquid, or nasal spray forms.', 'Restez à l\'intérieur lorsque le taux de pollen est élevé, surtout les jours de vent.\r\nGardez les fenêtres fermées pour empêcher le pollen d\'entrer dans votre maison.\r\nUtilisez des purificateurs d\'air avec des filtres HEPA pour réduire les allergènes à l\'intérieur.\r\nÉvitez les activités de plein air qui peuvent vous exposer aux allergènes, en particulier pendant les périodes de pointe pollinique.\r\nLavez-vous les mains et le visage après avoir été à l\'extérieur pour éliminer le pollen de votre peau et de vos cheveux.\r\nPensez à porter des lunettes de soleil pour protéger vos yeux du pollen.\r\n\r\nAntihistaminiques : Les antihistaminiques en vente libre comme la loratadine, la cétirizine ou la fexofénadine peuvent aider à soulager les symptômes tels que les éternuements, les démangeaisons, l\'écoulement nasal et les yeux qui piquent/larmoiement. Ils sont disponibles sous forme de comprimés, de liquide ou de vaporisateur nasal.'),
(12, 'أدوية الإغاثة السريعة (موسعات الشعب الهوائية): توفر هذه الأدوية راحة فورية أثناء نوبة الربو عن طريق إرخاء العضلات حول الشعب الهوائية وفتحها. تستخدم ناهضات بيتا قصيرة المفعول (SABAs) مثل ألبوتيرول بشكل شائع للتخفيف السريع.\r\n\r\nأدوية التحكم: يتم تناول هذه الأدوية بانتظام للسيطرة على أعراض الربو والوقاية منها. تساعد في تقليل الالتهاب في الشعب الهوائية وتمنع نوبات الربو. تشمل أدوية التحكم الكورتيكوستيرويدات المستنشقة (ICS) ، ناهضات بيتا طويلة المفعول (LABAs) ، معدلات الليكوترين ، مثبتات الخلايا البدينة ، وأجهزة الاستنشاق المركبة (ICS / LABA).\r\n\r\nأجهزة الاستنشاق بالجرعات المقننة (MDIs): توصل هذه الأجهزة المحمولة باليد الدواء في شكل ضباب يمكن استنشاقه مباشرة في الرئتين. يتم استخدامها مع الفواصل أو غرف التثبيت لتحسين توصيل الأدوية وتقليل مخاطر الآثار الجانبية.', 'Quick-relief medications (Bronchodilators): These medications provide immediate relief during an asthma attack by relaxing the muscles around the airways and opening them up. Short-acting beta-agonists (SABAs) like albuterol are commonly used for quick relief.\r\n\r\nController medications: These medications are taken regularly to control and prevent asthma symptoms. They help reduce inflammation in the airways and prevent asthma attacks. Controller medications include inhaled corticosteroids (ICS), long-acting beta-agonists (LABAs), leukotriene modifiers, mast cell stabilizers, and combination inhalers (ICS/LABA).\r\n\r\nMetered-dose inhalers (MDIs): These handheld devices deliver medication in a mist form that can be inhaled directly into the lungs. They are used with spacers or holding chambers to improve medication delivery and reduce the risk of side effects.\r\n', 'Médicaments à soulagement rapide (bronchodilatateurs) : ces médicaments procurent un soulagement immédiat lors d\'une crise d\'asthme en relaxant les muscles autour des voies respiratoires et en les ouvrant. Les bêta-agonistes à courte durée d\'action (SABA) comme l\'albutérol sont couramment utilisés pour un soulagement rapide.\r\n\r\nMédicaments de contrôle : Ces médicaments sont pris régulièrement pour contrôler et prévenir les symptômes de l\'asthme. Ils aident à réduire l\'inflammation des voies respiratoires et à prévenir les crises d\'asthme. Les médicaments de contrôle comprennent les corticostéroïdes inhalés (ICS), les bêta-agonistes à longue durée d\'action (LABA), les modificateurs des leucotriènes, les stabilisateurs des mastocytes et les inhalateurs combinés (ICS/LABA).\r\n\r\nInhalateurs-doseurs (MDI) : ces appareils portables délivrent des médicaments sous forme de brouillard qui peuvent être inhalés directement dans les poumons. Ils sont utilisés avec des entretoises ou des chambres de rétention pour améliorer l\'administration des médicaments et réduire le risque d\'effets secondaires.'),
(13, 'الأدوية المضادة للالتهابات: يمكن أن تساعد الأدوية مثل aminosalicylates (على سبيل المثال ، mesalamine) ، أو الكورتيكوستيرويدات ، أو أجهزة المناعة (مثل الآزوثيوبرين ، 6-مركابتوبورين) في تقليل الالتهاب في الأمعاء والسيطرة على الأعراض.\r\n\r\nالعلاجات البيولوجية: الأدوية البيولوجية ، مثل مثبطات عامل نخر الورم (TNF) (على سبيل المثال ، إينفليكسيماب ، أداليموماب) ، مثبطات إنترلوكين -12 / 23 (على سبيل المثال ، ustekinumab) ، أو مضادات مستقبلات الإنتجرين (على سبيل المثال ، vedolizumab) ، أو البروتينات المستهدفة أو المناعة. مسارات تشارك في التهاب التهاب الأمعاء.\r\n\r\nالمضادات الحيوية: يمكن وصف المضادات الحيوية لعلاج الالتهابات أو لتقليل الالتهاب في حالات معينة من مرض كرون.\r\n\r\nالتغييرات الغذائية: على الرغم من عدم وجود نظام غذائي واحد يناسب الجميع لمرض التهاب الأمعاء ، إلا أن بعض الأفراد يجدون تخفيفًا للأعراض عن طريق تجنب الأطعمة المحفزة أو اتباع أنظمة غذائية معينة مثل نظام FODMAP الغذائي المنخفض أو نظام غذائي محدد الكربوهيدرات. يمكن أن تساعد استشارة اختصاصي تغذية مسجل في إنشاء خطة نظام غذائي فردية.', 'Anti-inflammatory drugs: Medications such as aminosalicylates (e.g., mesalamine), corticosteroids, or immunomodulators (e.g., azathioprine, 6-mercaptopurine) can help reduce inflammation in the intestines and control symptoms.\r\n\r\nBiologic therapies: Biologic medications, such as tumor necrosis factor (TNF) inhibitors (e.g., infliximab, adalimumab), interleukin-12/23 inhibitors (e.g., ustekinumab), or integrin receptor antagonists (e.g., vedolizumab), target specific proteins or immune pathways involved in IBD inflammation.\r\n\r\nAntibiotics: Antibiotics may be prescribed to treat infections or to reduce inflammation in specific cases of Crohn\'s disease.\r\n\r\nDietary changes: While there is no one-size-fits-all diet for IBD, some individuals find symptom relief by avoiding trigger foods or following specific diets like the low FODMAP diet or specific carbohydrate diet. Consulting a registered dietitian can help create an individualized diet plan.', 'Médicaments anti-inflammatoires : les médicaments tels que les aminosalicylates (par exemple, la mésalamine), les corticostéroïdes ou les immunomodulateurs (par exemple, l\'azathioprine, la 6-mercaptopurine) peuvent aider à réduire l\'inflammation dans les intestins et à contrôler les symptômes.\r\n\r\nThérapies biologiques : les médicaments biologiques, tels que les inhibiteurs du facteur de nécrose tumorale (TNF) (par exemple, l\'infliximab, l\'adalimumab), les inhibiteurs de l\'interleukine-12/23 (par exemple, l\'ustekinumab) ou les antagonistes des récepteurs de l\'intégrine (par exemple, le vedolizumab), ciblent des protéines spécifiques voies impliquées dans l\'inflammation des MICI.\r\n\r\nAntibiotiques : Des antibiotiques peuvent être prescrits pour traiter les infections ou pour réduire l\'inflammation dans des cas spécifiques de la maladie de Crohn.\r\n\r\nChangements alimentaires : bien qu\'il n\'existe pas de régime alimentaire unique pour les MII, certaines personnes trouvent un soulagement des symptômes en évitant les aliments déclencheurs ou en suivant des régimes spécifiques comme le régime pauvre en FODMAP ou un régime spécifique en glucides. Consulter un diététiste peut aider à créer un régime alimentaire individualisé.'),
(14, 'الحد من التعرض لمسببات الحساسية: ابق في الداخل خلال أوقات ذروة حبوب اللقاح ، وأبق النوافذ مغلقة ، واستخدم أجهزة تنقية الهواء مع مرشحات HEPA ، ونظف الفراش بانتظام لتقليل التعرض لمسببات الحساسية.\r\n\r\nالوقاية من عث الغبار: استخدم أغطية مقاومة للحساسية للوسائد والمراتب ، واغسل الفراش في الماء الساخن أسبوعيًا ، واستخدم المكنسة الكهربائية بشكل متكرر لتقليل عث الغبار.\r\n\r\nالتحكم في وبر الحيوانات الأليفة: أبعد الحيوانات الأليفة عن غرفة النوم ، واغسلها بانتظام ، واستخدم مرشحات الهواء HEPA لتقليل وبر الحيوانات الأليفة في الهواء.\r\n\r\nمضادات الهيستامين: يمكن أن تساعد مضادات الهيستامين التي لا تستلزم وصفة طبية مثل اللوراتادين أو السيتريزين أو الفكسوفينادين في تخفيف الأعراض مثل العطس والحكة وسيلان الأنف وحكة / عيون دامعة. وهي متوفرة في شكل أقراص أو سائل أو رذاذ أنفي.', 'Limit exposure to allergens: Stay indoors during peak pollen times, keep windows closed, use air purifiers with HEPA filters, and regularly clean bedding to reduce exposure to allergens.\r\n\r\nDust mite prevention: Use allergen-proof covers for pillows and mattresses, wash bedding in hot water weekly, and vacuum frequently to minimize dust mites.\r\n\r\nPet dander control: Keep pets out of the bedroom, wash them regularly, and use HEPA air filters to reduce pet dander in the air.\r\n\r\nAntihistamines: Over-the-counter antihistamines like loratadine, cetirizine, or fexofenadine can help relieve symptoms such as sneezing, itching, runny nose, and itchy/watery eyes. They are available in tablet, liquid, or nasal spray forms.', 'Limitez l\'exposition aux allergènes : restez à l\'intérieur pendant les périodes de pointe de pollen, gardez les fenêtres fermées, utilisez des purificateurs d\'air avec des filtres HEPA et nettoyez régulièrement la literie pour réduire l\'exposition aux allergènes.\r\n\r\nPrévention des acariens : Utilisez des housses anti-allergènes pour les oreillers et les matelas, lavez la literie à l\'eau chaude chaque semaine et passez fréquemment l\'aspirateur pour minimiser les acariens.\r\n\r\nContrôle des squames d\'animaux : gardez les animaux hors de la chambre, lavez-les régulièrement et utilisez des filtres à air HEPA pour réduire les squames d\'animaux dans l\'air.\r\n\r\nAntihistaminiques : Les antihistaminiques en vente libre comme la loratadine, la cétirizine ou la fexofénadine peuvent aider à soulager les symptômes tels que les éternuements, les démangeaisons, l\'écoulement nasal et les yeux qui piquent/larmoiement. Ils sont disponibles sous forme de comprimés, de liquide ou de vaporisateur nasal.'),
(15, 'احصل على قسط وافر من الراحة للسماح لجسمك بالشفاء.\r\nحافظ على رطوبتك عن طريق شرب الكثير من السوائل مثل الماء أو الشاي الدافئ أو السوائل المهدئة مثل المرق الدافئ أو الحساء.\r\nتغرغر بالمياه المالحة الدافئة (1/4 إلى 1/2 ملعقة صغيرة من الملح مذاب في 8 أونصات من الماء الدافئ) عدة مرات في اليوم لتهدئة الحلق وتقليل الالتهاب.\r\nاستخدم مستحلبات الحلق أو الحلوى الصلبة لتخفيف الألم مؤقتًا والحفاظ على رطوبة الحلق.\r\nيمكن أن تساعد العقاقير غير الستيرويدية المضادة للالتهابات (NSAIDs) مثل الأيبوبروفين أو الأسيتامينوفين في تقليل الألم والالتهاب المرتبط بالتهاب الحلق. اتبع التعليمات والجرعة الموصى بها من قبل أخصائي الرعاية الصحية الخاص بك.', 'Get plenty of rest to allow your body to heal.\r\nStay hydrated by drinking plenty of fluids like water, warm tea, or soothing liquids like warm broth or soup.\r\nGargle with warm saltwater (1/4 to 1/2 teaspoon of salt dissolved in 8 ounces of warm water) several times a day to soothe the throat and reduce inflammation.\r\nUse throat lozenges or hard candies to temporarily relieve pain and keep the throat moist.\r\nNonsteroidal anti-inflammatory drugs (NSAIDs) like ibuprofen or acetaminophen can help reduce pain and inflammation associated with a sore throat. Follow the instructions and dosage recommended by your healthcare professional.', 'Reposez-vous suffisamment pour permettre à votre corps de guérir.\r\nRestez hydraté en buvant beaucoup de liquides comme de l\'eau, du thé chaud ou des liquides apaisants comme du bouillon chaud ou de la soupe.\r\nSe gargariser avec de l\'eau salée tiède (1/4 à 1/2 cuillère à café de sel dissous dans 8 onces d\'eau tiède) plusieurs fois par jour pour apaiser la gorge et réduire l\'inflammation.\r\nUtilisez des pastilles pour la gorge ou des bonbons durs pour soulager temporairement la douleur et garder la gorge humide.\r\nLes anti-inflammatoires non stéroïdiens (AINS) comme l\'ibuprofène ou l\'acétaminophène peuvent aider à réduire la douleur et l\'inflammation associées à un mal de gorge. Suivez les instructions et la posologie recommandées par votre professionnel de la santé.'),
(16, 'احصل على قسط كافٍ من الراحة للسماح لجسمك بالتعافي.\r\nحافظ على رطوبتك عن طريق شرب السوائل مثل الماء أو شاي الأعشاب أو المرق الصافي لمنع الجفاف.\r\nمسكنات الألم ومخفضات الحمى: يمكن أن تساعد العقاقير غير الستيرويدية المضادة للالتهابات (NSAIDs) مثل الأيبوبروفين أو الأسيتامينوفين في تقليل الحمى وتخفيف آلام الجسم وتخفيف الصداع. اتبع تعليمات الجرعة الموصى بها.\r\nمثبطات السعال والطارد: يمكن أن تساعد أدوية السعال المتاحة دون وصفة طبية في تخفيف أعراض السعال. يمكن أن تساعد طارد البلغم على ترقيق المخاط وتسهيل طرده.\r\nمزيلات الاحتقان: إذا كنت تعاني من احتقان الأنف ، فيمكن أن تساعد مضادات الاحتقان التي تُصرف دون وصفة طبية في تخفيف أعراض الأنف مؤقتًا. كن حذرًا عند استخدام مزيلات الاحتقان ، خاصة إذا كنت تعاني من أي حالات طبية كامنة ، واتبع التعليمات الموجودة على العبوة.', 'Get plenty of rest to allow your body to recover.\r\nStay hydrated by drinking fluids like water, herbal tea, or clear broths to prevent dehydration.\r\nPain relievers and fever reducers: Nonsteroidal anti-inflammatory drugs (NSAIDs) such as ibuprofen or acetaminophen can help reduce fever, relieve body aches, and alleviate headaches. Follow the recommended dosage instructions.\r\nCough suppressants and expectorants: Over-the-counter cough medications can help relieve cough symptoms. Expectorants can help thin mucus and make it easier to expel.\r\nDecongestants: If you have nasal congestion, over-the-counter decongestants can help temporarily relieve nasal symptoms. Be cautious when using decongestants, especially if you have any underlying medical conditions, and follow the instructions on the packaging.', 'Reposez-vous suffisamment pour permettre à votre corps de récupérer.\r\nRestez hydraté en buvant des liquides comme de l\'eau, des tisanes ou des bouillons clairs pour prévenir la déshydratation.\r\nAnalgésiques et antipyrétiques : les anti-inflammatoires non stéroïdiens (AINS) tels que l\'ibuprofène ou l\'acétaminophène peuvent aider à réduire la fièvre, à soulager les courbatures et à soulager les maux de tête. Suivez les instructions de dosage recommandées.\r\nAntitussifs et expectorants : Les médicaments contre la toux en vente libre peuvent aider à soulager les symptômes de la toux. Les expectorants peuvent aider à fluidifier le mucus et faciliter son expulsion.\r\nDécongestionnants : Si vous souffrez de congestion nasale, les décongestionnants en vente libre peuvent aider à soulager temporairement les symptômes nasaux. Soyez prudent lorsque vous utilisez des décongestionnants, surtout si vous avez des conditions médicales sous-jacentes, et suivez les instructions sur l\'emballage.'),
(17, 'محاليل معالجة الجفاف عن طريق الفم (ORS): تساعد هذه المحاليل ، المتوفرة بدون وصفة طبية ، في تعويض السوائل والإلكتروليتات المفقودة بسبب القيء والإسهال. يجب شرب أملاح الإماهة الفموية بكميات صغيرة بشكل متكرر لمنع الجفاف.\r\n\r\nالسوائل الصافية: بالإضافة إلى أملاح الإماهة الفموية ، يمكن أن تساعد السوائل الصافية مثل الماء أو المرق أو الحساء الصافي أو شاي الأعشاب أو المشروبات الغنية بالكهرباء في الحفاظ على رطوبتك. تجنب المشروبات التي تحتوي على الكافيين والكحول.\r\n\r\nمضادات القيء: في بعض الحالات ، يمكن وصف الأدوية المضادة للقىء للمساعدة في تخفيف الغثيان والقيء. يجب استخدام هذه الأدوية تحت إشراف أخصائي رعاية صحية.', 'Oral rehydration solutions (ORS): These solutions, available over-the-counter, help replace fluids and electrolytes lost due to vomiting and diarrhea. ORS should be sipped in small amounts frequently to prevent dehydration.\r\n\r\nClear fluids: In addition to ORS, clear liquids such as water, broth, clear soups, herbal tea, or electrolyte-rich drinks can help keep you hydrated. Avoid caffeinated and alcoholic beverages.\r\n\r\nAntiemetics: In some cases, antiemetic medications may be prescribed to help alleviate nausea and vomiting. These medications should be used under the guidance of a healthcare professional.', 'Solutions de réhydratation orale (SRO) : ces solutions, disponibles en vente libre, aident à remplacer les liquides et les électrolytes perdus en raison des vomissements et de la diarrhée. Les SRO doivent être bues fréquemment en petites quantités pour prévenir la déshydratation.\r\n\r\nLiquides clairs : En plus des SRO, des liquides clairs comme l\'eau, le bouillon, les soupes claires, les tisanes ou les boissons riches en électrolytes peuvent vous aider à rester hydraté. Évitez les boissons caféinées et alcoolisées.\r\n\r\nAntiémétiques : Dans certains cas, des médicaments antiémétiques peuvent être prescrits pour aider à soulager les nausées et les vomissements. Ces médicaments doivent être utilisés sous la direction d\'un professionnel de la santé.'),
(19, 'إذا كنت تسعل دمًا ، فمن المهم أن تسعى للحصول على رعاية طبية فورية. اتصل بخدمات الطوارئ أو قم بزيارة أقرب غرفة طوارئ لتلقي التقييم والرعاية الفورية.\r\n  سيجري الفريق الطبي تقييمًا شاملاً لتحديد سبب نفث الدم. قد يشمل ذلك أخذ تاريخ طبي مفصل وإجراء فحص بدني وطلب الاختبارات التشخيصية مثل الأشعة السينية للصدر أو الأشعة المقطعية أو تنظير القصبات أو اختبارات الدم.', 'If you are coughing up blood, it\'s important to seek immediate medical attention. Call emergency services or visit the nearest emergency room to receive prompt evaluation and care.\r\n The medical team will conduct a thorough evaluation to determine the cause of the hemoptysis. This may involve taking a detailed medical history, performing a physical examination, and ordering diagnostic tests such as chest X-rays, CT scans, bronchoscopy, or blood tests.', 'Si vous crachez du sang, il est important de consulter immédiatement un médecin. Appelez les services d\'urgence ou rendez-vous à la salle d\'urgence la plus proche pour recevoir une évaluation et des soins rapides.\r\n  L\'équipe médicale procédera à une évaluation approfondie pour déterminer la cause de l\'hémoptysie. Cela peut impliquer de prendre des antécédents médicaux détaillés, d\'effectuer un examen physique et de demander des tests de diagnostic tels que des radiographies pulmonaires, des tomodensitogrammes, une bronchoscopie ou des analyses de sang.'),
(20, 'في كثير من الحالات ، تكون تعديلات نمط الحياة هي خط العلاج الأول. قد يشمل ذلك اتباع نظام غذائي صحي للقلب ، وممارسة النشاط البدني بانتظام ، والإقلاع عن التدخين ، وإدارة الإجهاد ، والحفاظ على وزن صحي. يمكن أن تساعد هذه التغييرات في نمط الحياة في تحسين صحة القلب ومنع حدوث المزيد من المضاعفات.\r\n\r\nيمكن وصف الأدوية المختلفة لإدارة أمراض القلب. تشمل الأدوية الموصوفة بشكل شائع ما يلي:\r\n\r\nحاصرات بيتا: تساعد هذه الأدوية في خفض ضغط الدم وتقليل معدل ضربات القلب وتقليل عبء العمل على القلب.\r\n\r\nيجب عليك الاتصال بالطبيب بأسرع ما يمكن.', 'In many cases, lifestyle modifications are the first line of treatment. This may include adopting a heart-healthy diet, engaging in regular physical activity, quitting smoking, managing stress, and maintaining a healthy weight. These lifestyle changes can help improve heart health and prevent further complications.\r\n\r\nVarious medications may be prescribed to manage heart conditions. Commonly prescribed medications include:\r\n\r\nBeta-blockers: These medications help lower blood pressure, reduce heart rate, and decrease the workload on the heart.\r\n\r\nu should call a doctor as fast as u can.', 'Dans de nombreux cas, les modifications du mode de vie sont la première ligne de traitement. Cela peut inclure l\'adoption d\'un régime alimentaire sain pour le cœur, la pratique d\'une activité physique régulière, l\'arrêt du tabac, la gestion du stress et le maintien d\'un poids santé. Ces changements de mode de vie peuvent aider à améliorer la santé cardiaque et à prévenir d\'autres complications.\r\n\r\nDivers médicaments peuvent être prescrits pour gérer les problèmes cardiaques. Les médicaments couramment prescrits comprennent :\r\n\r\nBêta-bloquants : ces médicaments aident à abaisser la tension artérielle, à réduire la fréquence cardiaque et à réduire la charge de travail du cœur.\r\n\r\nvous devriez appeler un médecin aussi vite que possible.'),
(21, 'اتصل بأخصائي الرعاية الصحية على الفور. حدد موعدًا مع طبيب الرعاية الأولية أو طبيب المسالك البولية أو قم بزيارة مرفق الرعاية العاجلة. سيقومون بتقييم حالتك وإجراء الاختبارات اللازمة وتقديم العلاج المناسب.\r\nاشرب الكثير من السوائل ، وخاصة الماء. يمكن أن يساعد الترطيب الكافي في تخفيف البول وقد يقلل الانزعاج أثناء التبول.\r\n\r\nالامتناع عن تناول الكحوليات ، والكافيين ، والأطعمة الحارة ، لأنها يمكن أن تهيج المسالك البولية.', 'Contact a healthcare professional promptly. Schedule an appointment with your primary care physician, urologist, or visit an urgent care facility. They will evaluate your condition, perform necessary tests, and provide appropriate treatment.\r\nDrink plenty of fluids, especially water. Adequate hydration can help dilute the urine and may reduce discomfort during urination.\r\n\r\nRefrain from consuming alcohol, caffeine, and spicy foods, as they can potentially irritate the urinary tract.\r\n', 'Contactez rapidement un professionnel de la santé. Prenez rendez-vous avec votre médecin traitant, votre urologue ou rendez-vous dans un établissement de soins d\'urgence. Ils évalueront votre état, effectueront les tests nécessaires et fourniront un traitement approprié.\r\nBuvez beaucoup de liquides, surtout de l\'eau. Une hydratation adéquate peut aider à diluer l\'urine et peut réduire l\'inconfort pendant la miction.\r\n\r\nÉvitez de consommer de l\'alcool, de la caféine et des aliments épicés, car ils peuvent potentiellement irriter les voies urinaires.');

-- --------------------------------------------------------

--
-- Table structure for table `illness`
--

CREATE TABLE `illness` (
  `illness_id` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `illnessar` varchar(255) NOT NULL,
  `illnessen` varchar(255) NOT NULL,
  `illnessfr` varchar(255) NOT NULL,
  `images` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `illness`
--

INSERT INTO `illness` (`illness_id`, `level`, `illnessar`, `illnessen`, `illnessfr`, `images`) VALUES
(1, 2, 'حساسية', 'allergy', ' ALLERGIE', 'allergy.png'),
(2, 1, 'زكام', 'Cold', 'Rhume', 'cold.png'),
(3, 2, 'فيروس كورونا', 'Covid19', 'Covid19', 'corona.png'),
(4, 2, 'تسمم غذائي', 'Food poisonning', 'Intoxication alimentaire', 'food.png'),
(5, 1, 'زُكام', 'Common cold', 'Rhume', 'cold.png'),
(6, 1, 'الحساسية الموسمية', 'Seasonal allergies', 'Allergies saisonnières', 'seasonal-allergies.png'),
(7, 1, 'التهاب الحلق', 'Strep throat', 'L\'angine streptococcique', 'throat.png'),
(8, 1, 'التهاب الجيوب الأنفية', 'Sinusitis', 'Sinusite', ''),
(9, 2, 'صداع نصفي', 'Migraine', 'Migraine', 'migraine.png'),
(10, 1, 'مرض الجزر المعدي المريئي (جيرد)', 'Gastroesophageal reflux disease (GERD)', 'Reflux gastro-oesophagien (RGO)', 'images.png'),
(11, 1, 'حمى الكلأ', 'Hay fever', 'Rhume des foins', 'Hay_fever.png'),
(12, 1, 'الربو', 'Asthma', 'Asthma', 'asthma.png'),
(13, 2, 'مرض التهاب الأمعاء', 'Inflammatory bowel disease', 'Maladie inflammatoire de l\'intestin', 'bowel-flush.png'),
(14, 1, 'التهاب الأنف التحسسي', 'Allergic rhinitis', 'Rhinite allergique', 'runny-nose.png'),
(15, 2, 'إلتهاب الحلق', 'Sore throat', 'Mal de gorge', 'sore-throat.png'),
(16, 1, 'الانفلونزا', 'Influenza (Flu)\r\n', 'Grippe', 'influenza.png'),
(17, 2, 'التهاب المعدة والأمعاء', 'Gastroenteritis', 'Gastro-entérite', 'Gastroenteritis.png'),
(19, 2, 'التهاب رئوي', 'pneumonia', 'pneumonie', 'pneumonia.png'),
(20, 2, 'حالة القلب', 'heart condittion', 'problème cardiaque', 'heart-attack.png'),
(21, 2, 'حصاة كلوية', 'kidney stone', 'calcul rénal', 'drop-of-blood.png');

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `em_phone` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `cu_job` varchar(255) DEFAULT NULL,
  `pre_job` varchar(255) DEFAULT NULL,
  `desease` varchar(255) DEFAULT NULL,
  `id_card` int(11) DEFAULT NULL,
  `bloodtype` varchar(2) DEFAULT NULL,
  `image` text DEFAULT NULL,
  `last_connection_time` int(11) NOT NULL,
  `balance` int(11) NOT NULL DEFAULT 500
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `firstname`, `lastname`, `age`, `birth`, `gender`, `country`, `city`, `address`, `phone`, `em_phone`, `height`, `weight`, `cu_job`, `pre_job`, `desease`, `id_card`, `bloodtype`, `image`, `last_connection_time`, `balance`) VALUES
(133, 'dfasf', 'asdfas', 0, '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 500),
(144, 'dfasf', 'asdfas', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(145, 'dfasf', 'asdfas', 25, '2002-02-06', 'Male', 'vsdf', 'dfasf', 'fdasf', 25404, 2542, 2542, 254, 'sdasdf', 'fads', 'dfasfasd', 4564242, NULL, '', 0, 500),
(146, 'fdasf', 'asdfdafas', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(147, 'how', 'are u', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(149, '', '', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(150, 'farouk', 'zaouak', 21, '2002-06-02', 'Male', '', '', 'constantine', 662562426, 0, 165, 57, '', '', '', 0, NULL, '', 0, 500),
(151, '', '', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(152, '', '', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(153, 'ff', 'ff', 2, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(154, '', '', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(155, '', '', 0, '0000-00-00', NULL, '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(156, 'fdffffffffff', 'fffffffffffff', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, NULL, '', 0, 500),
(157, '', '', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, 'a+', '', 0, 500),
(158, '', '', 0, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', '', 0, 500),
(169, '', '', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718207-10000.jpg', 0, 500),
(170, '', '', 0, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718288-10000.jpg', 0, 500),
(171, '', '', 0, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718319-10000.jpg', 0, 500),
(172, '', '', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718475-10000.jpg', 0, 500),
(179, '', '', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718608-10000.jpg', 0, 500),
(181, '', '', 0, '0000-00-00', 'Female', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/28-04-2023 -1682718706-10000.jpg', 0, 500),
(183, '', '', 0, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/29-04-2023-1682754892-10000.jpg', 0, 500),
(185, '', '', 0, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, '', '', '', 0, '', 'images/29-04-2023-1682766765-10000.jpg', 0, 500),
(186, 'farouk', 'farouk', 0, '2002-08-01', 'Male', 'fdasfasd', 'fdsafsad', 'constantine alg', 32131, 321312, 187, 25, '', '', '', 23123123, 'AB', 'images/03-05-2023-1683129934-10000.jpg', 0, 500),
(195, 'farouk', 'farouk', NULL, '2002-08-01', 'Male', 'fdasfasd', 'fdsafsad', 'constantine alg', 32131, 321312, 187, 25, NULL, NULL, '', 23123123, 'AB', 'images/03-05-2023-1683130272-10000.jpg', 0, 500),
(196, '', '', NULL, '0000-00-00', 'Male', '', '', '', 0, 0, 0, 0, NULL, NULL, '', 0, 'A-', NULL, 0, 500),
(206, 'ahmed', 'meribout', NULL, '2023-07-12', 'Male', 'ejdu', 'didbdu', 'ejejduwh', 662695899, 911, 180, 75, NULL, NULL, 'corona', 4918, 'A+', 'images/19-05-2023-1684508767-10000.jpg', 0, 500),
(208, 'fdsa', 'fdasfsa', NULL, '2023-05-08', 'Male', 'fdasfa', 'dfsfasda', 'fdasf', 3213, 2313, 213, 52, NULL, NULL, '', 35432, 'O-', 'images/22-05-2023-1684784923-10000.jpg', 2147483647, 500),
(209, 'dfsaf', 'fadsfa', 0, '2023-06-14', 'Male', 'fdasf', 'fdsafsda', 'fdasf', 5245254, 254245, 150, 50, 'fdasf', NULL, 'fsdaf', 64564, 'O-', 'images/01-06-2023-1685613183-10000.jpg', 2147483647, 1450),
(210, 'farouk', 'zaouak', 21, '2002-06-02', 'Male', 'algeria', 'constantine', 'zwaghi sliman', 662695899, 911, 183, 78, 'job less', NULL, '', 123456789, 'B+', 'images/05-06-2023-1685951355-10000.jpg', 2147483647, 880);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`message_id`, `doctor_id`, `user_id`, `message`, `time`) VALUES
(1, 0, 0, 'fgfg', '2023-05-08 19:55:16'),
(2, 1, 0, 'fgdfg', '2023-05-08 20:01:42'),
(3, 1, 0, 'fgdfg', '2023-05-08 20:01:44'),
(4, 158, 0, 'dfdfsd', '2023-05-08 20:01:58'),
(5, 1, 0, 'test', '2023-05-08 23:05:00'),
(6, 0, 158, 'test', '2023-05-08 23:05:33'),
(7, 1, 0, 'test', '2023-05-08 23:06:28'),
(8, 1, 0, 'test', '2023-05-08 23:06:59'),
(9, 1, 0, 'test', '2023-05-08 23:07:01'),
(10, 1, 0, 'test', '2023-05-08 23:07:10'),
(11, 1, 0, 'test', '2023-05-08 23:10:09'),
(12, 1, 0, 'test', '2023-05-08 23:10:13'),
(13, 1, 0, 'test', '2023-05-08 23:10:37'),
(14, 1, 0, 'test', '2023-05-08 23:11:49'),
(15, 1, 158, 'test', '2023-05-08 23:13:06'),
(16, 1, 158, 'fefgfgfegdfgdf', '2023-05-10 10:46:07'),
(17, 1, 158, 'vuguy', '2023-05-10 11:35:42'),
(18, 1, 167, 'take medecin at 7 pm', '2023-05-23 10:16:00'),
(19, 1, 168, 'yu need to take your medication at 7 pm everyday', '2023-05-23 12:13:36'),
(20, 1, 167, 'bla bla bla', '2023-05-23 12:24:23'),
(21, 2, 210, 'hello', '2023-06-06 20:46:37');

-- --------------------------------------------------------

--
-- Table structure for table `pdf_data`
--

CREATE TABLE `pdf_data` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `pdf_data`
--

INSERT INTO `pdf_data` (`id`, `username`, `filename`, `user_id`, `doctor_id`, `time`) VALUES
(1, '', 'SEC-SCI-22_23-ADjenna_compressed.pdf', 0, 0, '2023-05-31 23:02:45'),
(2, '', 'SEC-SCI-22_23-ADjenna_compressed.pdf', 0, 0, '2023-05-31 23:03:03'),
(3, '', 'SEC-SCI-22_23-ADjenna_compressed.pdf', 0, 0, '2023-05-31 23:03:11'),
(4, '', '', 0, 0, '2023-05-31 23:04:57'),
(5, '', 'SEC-SCI-22_23-ADjenna_compressed.pdf', 0, 0, '2023-05-31 23:05:19'),
(6, '', 'Chapter3 (1).pdf', 0, 0, '2023-05-31 23:05:25'),
(7, '', 'Chapter3 (1).pdf', 0, 0, '2023-05-31 23:06:50'),
(8, '', 'SEC-SCI-22_23-ADjenna_compressed.pdf', 0, 0, '2023-05-31 23:06:55'),
(9, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:07:11'),
(10, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:13:02'),
(11, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:14:48'),
(12, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:17:38'),
(13, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:17:42'),
(14, '', 'memoirefinal.pdf', 0, 0, '2023-05-31 23:18:19'),
(15, '', 'Chapter1.pdf', 167, 1, '2023-05-31 23:20:12'),
(16, '', 'Chapter1.pdf', 167, 1, '2023-05-31 23:20:15'),
(17, '', 'test.pdf', 167, 1, '2023-05-31 23:20:23'),
(18, '', 'memoirefinal.pdf', 209, 1, '2023-06-03 18:31:39'),
(19, '', 'memoirefinal.pdf', 210, 1, '2023-06-05 17:07:11'),
(20, '', 'PARA-Tp-3.2.pdf', 210, 1, '2023-06-05 17:07:17'),
(21, '', 'PARA-Tp-3.1.pdf', 210, 1, '2023-06-05 17:07:26'),
(22, '', 'Chapter1 (1).pdf', 210, 1, '2023-06-05 17:10:09'),
(23, '', 'memoirefinal.pdf', 210, 2, '2023-06-06 19:46:29'),
(24, '', 'memoirefinal.pdf', 210, 2, '2023-06-06 19:46:47');

-- --------------------------------------------------------

--
-- Table structure for table `recent`
--

CREATE TABLE `recent` (
  `user_id` int(11) NOT NULL,
  `diagnose_id` int(11) NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp(),
  `speech` text NOT NULL,
  `response` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recent`
--

INSERT INTO `recent` (`user_id`, `diagnose_id`, `time`, `speech`, `response`) VALUES
(1, 1, '2023-04-15 03:34:43', 'j\\gusggsgsd', 'sdgsdgsdgsd'),
(1, 4, '2023-04-15 03:37:00', 'urytry', 'rtyryrtyrty'),
(1, 5, '2023-04-15 04:09:20', '\\يل\\ل', 'سليسلسيل'),
(1, 6, '2023-04-15 04:59:03', 'asdasd', 'asdasda'),
(1, 7, '2023-04-15 04:11:58', 'I have headache', 'Parasetamol'),
(1, 8, '2023-04-15 04:18:40', '$speech', '$solution'),
(1, 9, '2023-04-15 04:20:55', 'I have headache', 'Parasetamol'),
(1, 10, '2023-04-15 04:21:51', 'I have headache', 'Parasetamol'),
(1, 11, '2023-04-15 04:22:50', 'I have headache', 'Parasetamol'),
(1, 12, '2023-04-15 04:27:29', '51451', '5654541'),
(1, 13, '2023-04-15 04:32:36', 'I have headache', ''),
(1, 14, '2023-04-15 04:37:48', 'I have headache', 'Parasetamol'),
(1, 15, '2023-04-15 04:38:17', 'I have headache and yesterday I have been in a car crash so please help me', 'Parasetamol'),
(1, 16, '2023-04-15 04:40:33', 'I have headache', 'Parasetamol'),
(1, 17, '2023-04-15 04:43:08', 'I have headache Hi how are you', 'Parasetamol'),
(1, 18, '2023-04-15 22:32:49', 'I have headache', 'Parasetamol'),
(1, 19, '2023-04-15 22:32:57', 'I have headache and I have been in car crash 2 months ago', 'Parasetamol'),
(1, 20, '2023-04-15 22:33:17', 'I have headache and I have been an accident 2 months ago', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 21, '2023-04-18 21:45:11', 'I have headache', 'Parasetamol'),
(1, 22, '2023-04-18 21:47:38', 'I have headache', 'Parasetamol'),
(1, 23, '2023-04-18 21:48:31', 'I have headache', 'Parasetamol'),
(1, 24, '2023-04-18 21:49:35', 'I have headache and you said they have been in car crash what should I do', 'Parasetamol'),
(1, 25, '2023-04-18 21:55:18', 'I have headache', 'Parasetamol'),
(1, 26, '2023-04-18 22:07:00', 'I have headache', 'Parasetamol'),
(1, 27, '2023-04-18 22:12:46', 'I have headache and yesterday been car accident', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 28, '2023-04-18 22:13:12', 'I have headache', 'Parasetamol'),
(1, 29, '2023-04-18 22:13:17', 'I have headache and yesterday repair car accident', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 30, '2023-04-18 22:15:08', 'I have headache on yesterday been car accidents', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 31, '2023-04-18 22:15:18', 'I have headache and yesterday bring car accident', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 32, '2023-04-18 22:16:18', 'I have headache and yesterday have any car accidents', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 33, '2023-04-18 22:18:15', 'I have headache and yesterday but in car accidents', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 34, '2023-04-19 16:48:13', 'accident', 'التقيؤ'),
(1, 35, '2023-04-22 19:43:00', 'I have headache', 'Parasetamol'),
(1, 36, '2023-04-22 19:46:23', 'I have had to have been in an accident', 'التقيؤ'),
(1, 37, '2023-04-22 19:46:30', 'I have headache and have been an accident yesterday', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 38, '2023-04-22 19:50:04', 'I have headache and yesterday I mean car accidents', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 39, '2023-04-22 19:50:12', 'I have headache', 'Parasetamol'),
(1, 40, '2023-04-22 19:50:33', 'I have headache', 'Parasetamol'),
(1, 41, '2023-04-22 19:55:58', 'I have headache', 'Parasetamol'),
(1, 42, '2023-04-22 19:56:01', 'I have headache', 'Parasetamol'),
(1, 43, '2023-04-22 19:56:06', 'Arabic yesterday been car accidents', 'التقيؤ'),
(1, 44, '2023-04-22 19:58:00', 'I have headache', 'Parasetamol'),
(1, 45, '2023-04-22 19:58:21', 'I have been in a car accidents on yesterday I have headache', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 46, '2023-04-22 20:02:38', 'are available in car accidents', ''),
(1, 47, '2023-04-22 20:11:45', 'I have headache', 'Parasetamol'),
(1, 48, '2023-04-22 20:11:50', 'I like that but yesterday I mean car accidents', 'التقيؤ'),
(1, 49, '2023-04-22 20:11:55', 'I have been in a car accident and have headache', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 50, '2023-04-22 20:12:05', 'I have headache', 'Parasetamol'),
(1, 51, '2023-04-22 20:12:21', 'I have headache', 'Parasetamol'),
(1, 52, '2023-04-22 20:12:26', 'I have had that again yesterday been in car accidents', 'التقيؤ'),
(1, 53, '2023-04-22 20:12:55', 'I have headache blah blah blah blah blah blah blah blah blah blah blah', 'Parasetamol'),
(1, 54, '2023-04-22 20:13:08', 'I have headache blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah', 'Parasetamol'),
(1, 55, '2023-04-22 20:14:16', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'Parasetamol'),
(1, 56, '2023-04-22 20:14:27', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'التقيؤ'),
(1, 57, '2023-04-22 20:14:31', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 58, '2023-04-22 20:14:35', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'Parasetamol'),
(1, 59, '2023-04-22 20:14:45', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'التقيؤ'),
(1, 60, '2023-04-22 20:14:48', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'Parasetamol'),
(1, 61, '2023-04-22 20:15:37', 'I have headache', 'Parasetamol'),
(1, 62, '2023-04-22 20:15:54', 'lol', 'Parasetamol'),
(1, 63, '2023-04-22 20:19:30', 'lol', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 64, '2023-04-22 20:28:09', 'lol', 'Parasetamol'),
(1, 65, '2023-04-22 20:32:04', 'I have headache', 'Parasetamol'),
(1, 66, '2023-04-22 20:32:16', 'lol\'l', 'Parasetamol'),
(1, 67, '2023-04-22 20:32:20', 'lol\'l', 'التقيؤ'),
(1, 68, '2023-04-22 20:32:24', 'lol\'l', 'التقيؤ'),
(1, 69, '2023-04-22 20:32:30', 'lol\'l', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 70, '2023-04-22 20:32:41', 'I\'ve had a good news today I\'ve been car accidents', 'التقيؤ'),
(1, 71, '2023-04-22 20:32:46', 'I have it again yesterday I have been in a car accident', 'التقيؤ'),
(1, 72, '2023-04-22 20:32:52', 'I have headache and yesterday I\'ve been in car accident', 'You may have a seizure please go to the nearest hospital with an RMI scan '),
(1, 73, '2023-04-25 19:57:07', 'I have headache', 'Parasetamol'),
(158, 74, '2023-04-25 20:32:02', 'I have headache', 'Parasetamol'),
(158, 75, '2023-04-25 20:38:58', 'I have headache', 'Parasetamol'),
(151, 76, '2023-04-25 21:15:25', 'I have headache', 'Parasetamol'),
(185, 77, '2023-05-03 17:38:54', 'I have headache', 'Parasetamol'),
(185, 78, '2023-05-03 17:41:02', 'I think I have headache', 'Parasetamol'),
(185, 79, '2023-05-09 00:39:44', 'I have a headache', 'Parasetamol'),
(185, 80, '2023-05-20 10:59:50', 'راسي يوجع,حنجرتي تحرقني,حنجره,درجه الحراره مرتفعه,ناتس بزاف.', 'No Response'),
(185, 81, '2023-05-20 11:03:03', 'just listening.', 'No Response'),
(185, 82, '2023-05-20 11:04:01', 'listening to sell.', 'No Response'),
(185, 83, '2023-05-20 11:09:03', 'check his name.', 'No Response'),
(185, 84, '2023-05-20 11:09:30', 'راسي يوجع.', 'No Response'),
(185, 85, '2023-05-20 11:12:15', 'Allison,I have headache,my throat is dry,I sneeze a lot.', 'No Response'),
(185, 86, '2023-05-20 11:13:24', 'راسي يوجع,حنجره تاعي شيخه,درجه الحراره مرتفعه,ناتس بزاف.', 'No Response'),
(185, 87, '2023-05-20 11:14:27', 'راسي يوجع,حنجره تاعي شيحه,درجه الحراره مرتفعه,ناتس بزاف,ناطس بزاف,نعطس بزاف.', ''),
(185, 88, '2023-05-20 11:15:36', 'راسي يوجع,حنجره تاعي شيحه,درجه الحراره مرتفعه,ناتس بزاف,ناطس بزاف,نعطس بزاف.', ''),
(185, 89, '2023-05-20 11:16:11', 'راسي يوجع,حنجره تاعي شيحه,درجه الحراره مرتفعه,ناتس بزاف,ناطس بزاف,نعطس بزاف.', ''),
(185, 90, '2023-05-20 11:16:53', 'راسي يوجع,حنجره تاعي شيحه,درجه الحراره مرتفعه,ناتس بزاف,ناطس بزاف,نعطس بزاف,chocolate.', ''),
(209, 91, '2023-06-01 15:06:48', 'hello see you Johnny,and I\'ll see you Johnny,راسي يوجعني.', 'No Response'),
(209, 92, '2023-06-01 15:07:01', 'أنا آسف لأنني لم أستطع فهمك أو لم نجد حلاً. الرجاء الاتصال بالطبيب.\r.', 'No Response'),
(209, 93, '2023-06-04 13:50:30', 'headache.', 'No Response'),
(209, 94, '2023-06-04 13:54:48', 'headache.', 'No Response'),
(209, 95, '2023-06-04 13:55:37', 'headache.', 'No Response'),
(209, 96, '2023-06-04 13:58:59', 'headache.', 'No Response'),
(209, 97, '2023-06-04 14:02:56', 'headache.', 'No Response'),
(209, 98, '2023-06-04 16:34:57', 'headache,itching.', 'No Response'),
(209, 99, '2023-06-04 16:35:46', 'headache.', 'No Response'),
(209, 100, '2023-06-04 16:37:04', 'headache.', 'No Response'),
(209, 101, '2023-06-04 17:14:14', 'headache,I guess another,poisoning.', 'No Response'),
(209, 102, '2023-06-04 17:14:41', 'fever.', 'No Response'),
(209, 103, '2023-06-04 17:15:47', 'fever.headache.', 'Food poisonning'),
(209, 104, '2023-06-04 17:19:13', 'fever.headache.slow down,صداع,سخفني,شخصي.', 'No Response'),
(209, 105, '2023-06-04 19:11:31', 'headache.', 'No Response'),
(209, 106, '2023-06-04 19:38:03', 'headache,fever,vomiting,dizziness,diarrhea,stomach.', 'Food poisonning'),
(210, 107, '2023-06-05 08:51:30', 'stomach,diarrhea,fever.', 'Food poisonning'),
(210, 108, '2023-06-05 08:52:29', 'stomach,diarrhea.', 'Food poisonning'),
(210, 109, '2023-06-05 08:54:45', 'stomach,diarrhea.', 'Food poisonning'),
(210, 110, '2023-06-05 08:56:08', 'diarrhea,stomach.', 'Food poisonning'),
(210, 111, '2023-06-05 08:57:04', 'stomach,diarrhea.', 'Food poisonning'),
(210, 112, '2023-06-05 09:01:14', 'diarrhea,stomach.', 'Food poisonning'),
(210, 113, '2023-06-05 09:04:01', 'diarrhea,stomach.', 'Food poisonning'),
(210, 114, '2023-06-05 09:06:32', 'stomach,diarrhea.', 'Food poisonning'),
(210, 115, '2023-06-05 09:08:02', 'stomach,diarrhea.', 'Food poisonning'),
(210, 116, '2023-06-05 09:09:33', 'stomach,diarrhea.', 'Food poisonning'),
(210, 117, '2023-06-05 09:10:57', 'stomach,diarrhea.', 'Food poisonning'),
(210, 118, '2023-06-05 09:12:22', 'sneezing,headache,throat,fever.', 'Cold'),
(210, 119, '2023-06-05 09:15:12', 'diarrhea,stomach.', 'Food poisonning'),
(210, 120, '2023-06-05 09:20:25', 'stomach,diarrhea.', 'Food poisonning'),
(210, 121, '2023-06-05 09:21:30', 'headache,runny nose,itching,and I die,sneezing,throats,and I,but I die,red eyes.', 'No Response'),
(210, 122, '2023-06-05 09:22:39', 'make a sweater headache,I already knows,throats,fever,tired,taste,runny nose.', 'No Response'),
(210, 123, '2023-06-05 09:24:28', 'headache,sneezing,throats,fever.', 'Cold'),
(210, 124, '2023-06-05 09:25:52', 'diarrhea,stomach.', 'Food poisonning'),
(210, 125, '2023-06-05 09:27:42', 'diarrhea,stomach,Megan ask me.', 'Food poisonning'),
(210, 126, '2023-06-05 09:28:36', 'diarrhea,stomach.', 'Food poisonning'),
(210, 127, '2023-06-05 09:30:14', 'stomach,diarrhea,diagnosed me.', 'Food poisonning'),
(210, 128, '2023-06-05 09:58:40', 'sneezing,headache,throats,fever,throat.', 'Cold'),
(210, 129, '2023-06-05 09:59:19', 'headache,already knows,runny nose,throat,fever,tired,taste.', 'No Response'),
(210, 130, '2023-06-05 10:01:37', 'headache,already knows,runny nose,throat,fever,tired,taste.', 'Covid19'),
(210, 131, '2023-06-05 10:02:26', 'headache,runny nose,itching,red eye,sneezing.', 'allergy'),
(210, 132, '2023-06-05 10:30:17', 'اني غلبت,اني غلبان,ما نقدرش نذوق,نتقيه بزاف,ضربتني الدوخه,كاسي توساني,كرسي توجعني,كرشي توجعني,كرسي جاريه,كرشي جاريه,check his name,just listening.', 'No Response'),
(210, 133, '2023-06-05 10:31:00', 'كرشي توجع,كرسي جاريه,كرشي جاريه.', ''),
(210, 134, '2023-06-05 10:45:56', 'خشمي حك,راني نحك,عيني حمراء,ناطس بزاف.', 'No Response'),
(210, 135, '2023-06-05 10:46:51', 'أنا آسف لأنني لم أستطع فهمك أو لم نجد حلاً. الرجاء الاتصال بالطبيب.\r\nخشمي,نحك,عيني,نعطس.', ''),
(210, 136, '2023-06-05 10:47:49', 'خشمي حك,نحك بزاف,عيني حمراء,نعطس بزاف.', ''),
(210, 137, '2023-06-05 10:50:18', 'راسي يوجع,نعطس بزاف,حنجره تاعي توجع,درجه الحراره تاي مرتفعه,حراره من درجه الحراره مرتفعه.', ''),
(210, 138, '2023-06-05 10:50:49', 'راسي يوجع,نعطس بزاف,حنجره تاعي توجع,درجه الحراره تاي مرتفع.', 'No Response'),
(210, 139, '2023-06-05 10:51:50', 'راسي يوج,خشمي حك,حنجره تيتوجان,ما نقدرش نذوق.', 'No Response'),
(210, 140, '2023-06-05 10:53:34', 'راسي يوجع,كرشي توجع,كرشي جاريه.', 'No Response'),
(210, 141, '2023-06-05 10:55:17', 'راسي يوجع,كرشي توجع,كرشي جاريه.', 'No Response'),
(210, 142, '2023-06-05 10:55:44', 'راسي يوجع,كرشي توجع,كرشي جاريه.', 'No Response'),
(210, 143, '2023-06-05 10:56:08', 'راسي يوجع,كرشي,كرشي جاريه.', 'No Response'),
(210, 144, '2023-06-05 10:56:44', 'راسي يوجع,كرشي,كرشي جاريه.', 'No Response'),
(210, 145, '2023-06-05 10:57:09', 'كرسي توجع,كرشي جاريه,راسي يوجع.', 'No Response'),
(210, 146, '2023-06-05 10:58:08', 'كرسي توجع,كرشي جاريه,راسي يوجع.success night.', 'No Response'),
(210, 147, '2023-06-05 10:58:37', 'كرسي توجع,كرشي جاريه,راسي يوج.', 'No Response'),
(210, 148, '2023-06-05 11:00:29', 'أنا آسف لأنني لم أستطع فهمك أو لم نجد حلاً. الرجاء الاتصال بالطبيب.\r\ndiarrhea,diarrhea,diarrhea,I have diarrhea,my stomach hurts,headache.', 'No Response'),
(210, 149, '2023-06-05 11:01:41', 'خشمي,نحك,هيني,نعطس,عيني.', ''),
(210, 150, '2023-06-05 11:02:26', 'I don\'t see user,no Mr Sim Omaha and again,راسي يوجع,نعطس,طنجره,حراره مرتفعه.', 'No Response'),
(210, 151, '2023-06-05 11:03:25', 'راسي يوجع,نعطس,حنجره,حراره مرتفعه.', ''),
(210, 152, '2023-06-05 11:04:07', 'راسي يوجع,كرشي,كرسي توجع,كرسي جاريه.', 'No Response'),
(210, 153, '2023-06-05 11:04:53', 'كرشي توشه,كرسي جاريه,كرسي توجع,راسي يوجع.', 'No Response'),
(210, 154, '2023-06-05 11:06:28', 'حراره مرتفعه,كرشي توجع,كرشي جاريه.', ''),
(210, 155, '2023-06-05 11:08:00', 'راسي يوجع,نعطس بزاف,حنجره تاعي سايحه,حراره مرتفعه.', ''),
(210, 156, '2023-06-05 11:08:53', 'راسي يوجع,خشمي يحك,حنجره تاعي شيخه,ما نقدرش نذوق,سخصني.', ''),
(210, 157, '2023-06-05 11:09:47', 'حراره مرتفعه,كرسي توجع,كرسي جاريه بزاف.', 'No Response'),
(210, 158, '2023-06-05 11:10:09', 'حراره مرتفعه,كرشي توجع,كرشي جاريه.', ''),
(210, 159, '2023-06-05 11:18:24', 'راسي يوجع,نعطس بزاف,حنجره شايحه,طلال مصطفى,حراره مرتفعه.', ''),
(210, 160, '2023-06-05 11:21:25', 'حراره مرتفعه,كرسي توجع,كرشي جاريه.', ''),
(210, 161, '2023-06-05 11:23:18', 'حراره مرتفعه,كرشي جاريه,كرشي توجع.', ''),
(210, 162, '2023-06-05 18:22:49', 'head pain.', 'No Response'),
(210, 163, '2023-06-05 18:23:08', 'head pain.headache.', 'No Response'),
(210, 164, '2023-06-05 18:23:55', 'head pain,my head hurts.', 'No Response'),
(210, 165, '2023-06-05 18:26:21', 'head pain,my head hurts.', 'No Response'),
(210, 166, '2023-06-05 18:26:43', 'head pain,my head hurts.head pain.', 'No Response'),
(210, 167, '2023-06-05 18:26:56', 'I had pain.', 'No Response'),
(210, 168, '2023-06-05 18:27:07', 'I had pain.head pain.', 'No Response'),
(210, 169, '2023-06-05 18:27:26', 'I had pai.', 'No Response'),
(210, 170, '2023-06-05 18:28:38', 'I had pai.head pain.', 'No Response'),
(210, 171, '2023-06-05 18:28:46', 'I had pai.head pain.headache.', 'No Response'),
(210, 172, '2023-06-05 18:32:34', 'head hurts.', 'No Response'),
(210, 173, '2023-06-05 18:33:02', 'head hurts.', 'No Response'),
(210, 174, '2023-06-05 18:34:20', 'head hurts.', 'No Response'),
(210, 175, '2023-06-05 18:35:23', 'head hurts.', 'No Response'),
(210, 176, '2023-06-05 18:35:38', 'head hurts.headache.', 'No Response'),
(210, 177, '2023-06-05 18:35:53', 'head hurts.', 'No Response'),
(210, 178, '2023-06-05 18:36:12', 'head.', 'No Response'),
(210, 179, '2023-06-05 18:36:57', 'headache.', 'No Response'),
(210, 180, '2023-06-05 18:37:18', 'itching.', 'No Response'),
(210, 181, '2023-06-05 18:37:40', 'itching.headache.', 'No Response'),
(210, 182, '2023-06-05 18:41:01', 'head hurts.', 'No Response'),
(210, 183, '2023-06-05 18:42:48', 'I had to head hurts,sneezing,throat,fever.', 'No Response'),
(210, 184, '2023-06-05 18:53:02', 'راسي يوجع,عيني.', 'No Response'),
(210, 185, '2023-06-05 18:59:22', 'diarrhea.عيني,كرشي جاريه,داينوس مي.', 'No Response'),
(210, 186, '2023-06-05 19:05:03', 'diarrhea,stomach,fever.', 'No Response'),
(210, 187, '2023-06-05 19:06:04', 'diarrhea,stomach,fever.', 'Food poisonning'),
(217, 188, '2023-06-05 19:07:54', 'stomach,diarrhea,fever.', 'Food poisonning'),
(210, 189, '2023-06-06 09:51:31', 'throat,tired,taste.', 'No Response'),
(210, 190, '2023-06-06 09:52:20', 'headache,fever,stomach.', 'No Response'),
(210, 191, '2023-06-06 09:52:59', 'nullthe delete,the diarrhea,stomach,fever.', 'Food poisonning'),
(210, 192, '2023-06-06 09:55:56', 'stomach,diarrhea,fever.', 'Food poisonning'),
(210, 193, '2023-06-06 09:56:43', 'stomach.', 'No Response'),
(210, 194, '2023-06-06 09:58:05', 'stomach.', 'No Response'),
(210, 195, '2023-06-06 09:59:17', 'nullstomach.', 'No Response'),
(210, 196, '2023-06-06 09:59:34', 'the stomach.', 'No Response'),
(210, 197, '2023-06-06 10:00:31', 'headache.', 'No Response'),
(210, 198, '2023-06-06 10:22:08', 'stomach,headache.', 'No Response'),
(210, 199, '2023-06-06 10:22:30', 'nullstomach.', 'No Response'),
(210, 200, '2023-06-06 10:23:15', 'nullheadache,sneezing,throat,fever.', 'Cold'),
(210, 201, '2023-06-06 10:23:41', 'headache,itching,sneezing,throat,fever,tired.', 'No Response'),
(210, 202, '2023-06-06 10:24:10', 'dizziness,diarrhea.', 'Asthma'),
(210, 203, '2023-06-06 10:25:27', 'fever,tired,headache,runny nose.', 'No Response'),
(210, 204, '2023-06-06 10:26:02', 'nullsneezing,headache,throats,and fever.', 'Cold'),
(210, 205, '2023-06-06 10:26:29', 'runny nose,itching,red eyes,sneezing.', 'allergy'),
(210, 206, '2023-06-06 10:26:55', 'runny nose,the red eyes,sneezing.', 'No Response'),
(210, 207, '2023-06-06 10:27:40', 'runny nose,headache,throat,taste.', 'No Response'),
(210, 208, '2023-06-06 10:28:12', 'nullitching,Paradise,sneezing,red eyes.', 'Hay fever'),
(210, 209, '2023-06-06 10:28:47', 'runny nose,fever,tired.', 'No Response'),
(210, 210, '2023-06-06 10:30:44', 'nullnoses running.', 'No Response'),
(210, 211, '2023-06-06 10:31:12', 'nose is running,headache,throat,taste.', 'No Response'),
(210, 212, '2023-06-06 10:33:31', 'headache,itching,sneezing,throats,fever,tired.', 'No Response'),
(210, 213, '2023-06-06 10:34:13', 'headache,itching,sneezing,throats,fever,tired.', 'No Response'),
(210, 214, '2023-06-06 10:34:40', 'nullthroats,tired,taste.', 'No Response'),
(210, 215, '2023-06-06 10:48:06', 'headache,I don\'t he knows,throats,taste,all runny nose.', 'Covid19'),
(210, 216, '2023-06-06 10:51:43', 'راسي يوجع,ناقص بزاف,خنجره تاعي,حراره مرتفعه,خنجره تاعي,ناقص بزاف,نعطس.', 'No Response'),
(210, 217, '2023-06-06 10:54:01', 'خشمي,الحك,عيني,نعطس,الحك,الحك,نحك بزاف.', ''),
(210, 218, '2023-06-06 11:12:26', 'thought I see,راسي يوجع,ناطس,نعطس,حنجره تاعي الشيخه,حراره مرتفعه.', ''),
(210, 219, '2023-06-06 13:38:17', 'headache,runny nose,throat,taste.', 'Covid19'),
(210, 220, '2023-06-06 13:51:53', 'headache,sneezing,throats,fever.', 'Cold'),
(210, 221, '2023-06-06 16:22:04', 'this is area,cottage cheese area,كرشي جاريه,كرشي توجع,حراره مرتفعه.', ''),
(210, 222, '2023-06-06 21:03:15', 'already knows,runny nose,itching,Paradise,sneezing.', 'No Response'),
(210, 223, '2023-06-06 21:03:15', 'already knows,runny nose,itching,Paradise,sneezing.', 'No Response'),
(210, 224, '2023-06-06 21:03:42', 'already knows,runny nose,itching,Paradise,sneezing.runny nose,red eyes.', 'No Response'),
(210, 225, '2023-06-06 21:04:34', 'already knows,runny nose,itching,Paradise,sneezing.runny nose,red eyes.', 'allergy'),
(210, 226, '2023-06-06 21:04:34', 'already knows,runny nose,itching,Paradise,sneezing.runny nose,red eyes.', 'No Response'),
(210, 227, '2023-06-06 21:05:28', 'runny nose,itching,red eyes,sneezing.', 'allergy'),
(210, 228, '2023-06-06 21:05:28', 'runny nose,itching,red eyes,sneezing.', 'No Response'),
(210, 229, '2023-06-06 22:31:43', 'I have runny nose,my throat is itching,I think I have fever,I cannot taste,I vomit a lot,and I think I have diarrhea.', 'No Response'),
(210, 230, '2023-06-06 22:31:43', 'I have runny nose,my throat is itching,I think I have fever,I cannot taste,I vomit a lot,and I think I have diarrhea.', 'No Response'),
(210, 231, '2023-06-06 22:31:53', 'I have runny nose,my throat is itching,I think I have fever,I cannot taste,I vomit a lot,and I think I have diarrhea.', 'No Response'),
(210, 232, '2023-06-06 22:31:53', 'I have runny nose,my throat is itching,I think I have fever,I cannot taste,I vomit a lot,and I think I have diarrhea.', 'No Response'),
(210, 233, '2023-06-06 22:32:54', 'runny nose,throats,fever,taste,vomiting.', 'No Response'),
(210, 234, '2023-06-06 22:32:54', 'runny nose,throats,fever,taste,vomiting.', 'No Response'),
(210, 235, '2023-06-06 22:33:22', 'throats,fever,I\'m tired,runny nose.', 'No Response'),
(210, 236, '2023-06-06 22:33:22', 'throats,fever,I\'m tired,runny nose.', 'No Response'),
(210, 237, '2023-06-06 22:34:26', 'fever,tired,taste,diarrhea.', 'Influenza (Flu)\r\n'),
(210, 238, '2023-06-06 22:34:26', 'fever,tired,taste,diarrhea.', 'No Response'),
(210, 239, '2023-06-06 22:35:09', 'fever,tired,taste,diarrhea.fever,diarrhea,stomach.', 'No Response'),
(210, 240, '2023-06-06 22:35:09', 'fever,tired,taste,diarrhea.fever,diarrhea,stomach.', 'No Response'),
(210, 241, '2023-06-06 22:35:28', 'stomach,diarrhea,fever.', 'Food poisonning'),
(210, 242, '2023-06-06 22:35:28', 'stomach,diarrhea,fever.', 'No Response'),
(210, 243, '2023-06-06 22:35:37', 'stomach,diarrhea,fever.dizziness.', 'No Response'),
(210, 244, '2023-06-06 22:35:37', 'stomach,diarrhea,fever.dizziness.', 'No Response'),
(210, 245, '2023-06-06 22:35:58', 'stomach,dizziness,diarrhea,fever.', 'No Response'),
(210, 246, '2023-06-06 22:35:58', 'stomach,dizziness,diarrhea,fever.', 'No Response'),
(210, 247, '2023-06-06 22:36:19', 'diarrhea,stomach,fever.', 'Food poisonning'),
(210, 248, '2023-06-06 22:36:19', 'diarrhea,stomach,fever.', 'No Response'),
(210, 249, '2023-06-06 22:36:52', 'my head hurts,ice needs a lot,my throat my throat hurts,I think I have fever.', 'No Response'),
(210, 250, '2023-06-06 22:36:52', 'my head hurts,ice needs a lot,my throat my throat hurts,I think I have fever.', 'No Response'),
(210, 251, '2023-06-06 22:37:29', 'I I think I have I have headache,I sneeze a lot,my throat hurts,I think I have fever.', 'Cold'),
(210, 252, '2023-06-06 22:37:30', 'I I think I have I have headache,I sneeze a lot,my throat hurts,I think I have fever.', 'No Response'),
(210, 253, '2023-06-06 22:38:04', 'headache,runny nose,throats,and tast.', 'No Response'),
(210, 254, '2023-06-06 22:38:04', 'headache,runny nose,throats,and tast.', 'No Response'),
(210, 255, '2023-06-06 22:38:35', 'headache,runny nose,throat,taste.', 'Covid19'),
(210, 256, '2023-06-06 22:38:35', 'headache,runny nose,throat,taste.', 'No Response'),
(210, 257, '2023-06-06 22:38:39', 'headache,runny nose,throat,taste.', 'Covid19'),
(210, 258, '2023-06-06 22:38:39', 'headache,runny nose,throat,taste.', 'No Response'),
(210, 259, '2023-06-06 23:09:45', 'راسي يوجع,ناتس بزاف,نعطس بزاف,حنجره تاعي شيخه,حراره تاعي حراره مرتفعه.', ''),
(210, 260, '2023-06-07 00:05:39', 'coffin blood,coughing blood.', 'pee blood'),
(210, 261, '2023-06-07 00:05:39', 'coffin blood,coughing blood.', 'No Response'),
(210, 262, '2023-06-07 00:08:50', 'coughing blood.', 'pee blood'),
(210, 263, '2023-06-07 00:08:50', 'coughing blood.', 'No Response'),
(210, 264, '2023-06-07 00:10:40', 'heart.', 'pee blood'),
(210, 265, '2023-06-07 00:10:40', 'heart.', 'No Response'),
(210, 266, '2023-06-07 00:10:55', 'hello.', 'pee blood'),
(210, 267, '2023-06-07 00:10:55', 'hello.', 'No Response'),
(210, 268, '2023-06-07 00:15:56', 'hello.', 'coughing blood'),
(210, 269, '2023-06-07 00:15:56', 'hello.', 'No Response'),
(210, 270, '2023-06-07 00:29:34', '<br />\n<b>Fatal error</b>:  Uncaught ArgumentCountError: The number of elements in the type definition string must match the number of bind variables in C:xamppphtdocssi\returnresponseEN.php:56\nStack trace:\n#0 C:xamppphtdocssi\returnresponseEN.php(56): mysqli_stmt-&gt;bind_param(\'iiiiiiiiiiiiiii...\', false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false)\n#1 {main}\n  thrown in <b>C:xamppphtdocssi\returnresponseEN.php</b> on line <b>56</b><br />.', 'No Response'),
(210, 271, '2023-06-07 00:29:34', '<br />\n<b>Fatal error</b>:  Uncaught ArgumentCountError: The number of elements in the type definition string must match the number of bind variables in C:xamppphtdocssi\returnresponseEN.php:56\nStack trace:\n#0 C:xamppphtdocssi\returnresponseEN.php(56): mysqli_stmt-&gt;bind_param(\'iiiiiiiiiiiiiii...\', false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false)\n#1 {main}\n  thrown in <b>C:xamppphtdocssi\returnresponseEN.php</b> on line <b>56</b><br />.', 'No Response'),
(210, 272, '2023-06-07 00:29:52', 'heart.', 'heart condittion'),
(210, 273, '2023-06-07 00:29:52', 'heart.', 'No Response'),
(210, 274, '2023-06-07 00:30:21', 'coffin blood,coughing blood.', 'coughing blood'),
(210, 275, '2023-06-07 00:30:21', 'coffin blood,coughing blood.', 'No Response'),
(210, 276, '2023-06-07 00:45:08', 'cœur.', 'problème cardiaque'),
(210, 277, '2023-06-07 00:46:38', 'tousser du san.', 'No Response'),
(210, 278, '2023-06-07 00:47:16', 'tousser du sang.', 'pneumonie');

-- --------------------------------------------------------

--
-- Table structure for table `response`
--

CREATE TABLE `response` (
  `headache` tinyint(1) NOT NULL DEFAULT 0,
  `solution` text NOT NULL,
  `accident` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `response`
--

INSERT INTO `response` (`headache`, `solution`, `accident`) VALUES
(1, 'Parasetamol', 0),
(1, 'You may have a seizure please go to the nearest hospital with an RMI scan ', 1),
(0, 'التقيؤ', 1),
(0, 'التقيؤ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `simple_symptoms`
--

CREATE TABLE `simple_symptoms` (
  `symptom_id` int(11) NOT NULL,
  `photo` text NOT NULL,
  `symptomen` varchar(255) NOT NULL,
  `symptomar` varchar(255) NOT NULL,
  `symptomfr` varchar(255) NOT NULL,
  `treatmenten` text NOT NULL,
  `treatmentar` text NOT NULL,
  `treatmentfr` text NOT NULL,
  `headache` tinyint(1) NOT NULL DEFAULT 0,
  `runny_nose` tinyint(1) NOT NULL DEFAULT 0,
  `itching` tinyint(1) NOT NULL DEFAULT 0,
  `red_eyes` tinyint(1) NOT NULL DEFAULT 0,
  `sneezing` tinyint(1) NOT NULL DEFAULT 0,
  `throat` tinyint(1) NOT NULL DEFAULT 0,
  `fever` tinyint(1) NOT NULL DEFAULT 0,
  `tired` tinyint(1) NOT NULL DEFAULT 0,
  `taste` tinyint(1) NOT NULL DEFAULT 0,
  `vomitting` tinyint(1) NOT NULL DEFAULT 0,
  `dizziness` tinyint(1) NOT NULL DEFAULT 0,
  `diarrhea` tinyint(1) NOT NULL DEFAULT 0,
  `stomach` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `simple_symptoms`
--

INSERT INTO `simple_symptoms` (`symptom_id`, `photo`, `symptomen`, `symptomar`, `symptomfr`, `treatmenten`, `treatmentar`, `treatmentfr`, `headache`, `runny_nose`, `itching`, `red_eyes`, `sneezing`, `throat`, `fever`, `tired`, `taste`, `vomitting`, `dizziness`, `diarrhea`, `stomach`) VALUES
(1, 'headache.png', 'headache', 'صداع', 'mal de tête', 'Rest in a quiet, dark room.\r\nHot or cold compresses to your head or neck.\r\nMassage and small amounts of caffeine.\r\n\r\nPotential illnesses: Stroke,Dental problemsm,Covid,Concussion.', 'استرح في غرفة هادئة ومظلمة.\r\nكمادات ساخنة أو باردة على رأسك أو رقبتك.\r\nالتدليك بكميات قليلة من الكافيين.\r\nالأمراض المحتملة: السكتة الدماغية ، مشاكل الأسنان ، كوفيد ، ارتجاج.', 'Reposez-vous dans une pièce calme et sombre.\r\nCompresses chaudes ou froides sur la tête ou le cou.\r\nMassage et petites quantités de caféine.\r\nMaladies potentielles : AVC, problèmes dentaires, Covid, commotion cérébrale.', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 'abdominal-pain.png', 'Abdominal Pain', 'وجع بطن', 'Douleur Abdominale', 'Place a hot water bottle or heated wheat bag on your abdomen.\r\nDrink plenty of clear fluids such as water.\r\nReduce your intake of coffee, tea and alcohol as these can make the pain worse.\r\n\r\nPotential illnesses: irritable bowel syndrome,food allergies,lactose intolerance,food poisoning,and a stomach virus.', 'ضع زجاجة ماء ساخن أو كيس قمح ساخن على بطنك.\r\nاشرب الكثير من السوائل الصافية مثل الماء.\r\nقلل من تناول القهوة والشاي والكحول لأنها قد تزيد الألم سوءًا.\r\n\r\nالأمراض المحتملة: متلازمة القولون العصبي ، والحساسية الغذائية ، وعدم تحمل اللاكتوز ، والتسمم الغذائي ، وفيروس المعدة.', 'Placez une bouillotte ou un sac de blé chauffé sur votre abdomen.\r\nBuvez beaucoup de liquides clairs comme de l\'eau.\r\nRéduisez votre consommation de café, de thé et d\'alcool, car ils peuvent aggraver la douleur.\r\n\r\nMaladies potentielles : syndrome du côlon irritable, allergies alimentaires, intolérance au lactose, intoxication alimentaire et virus de l\'estomac.', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
(3, 'dizziness.png', 'Dizziness', 'دوخة', 'Vertiges', 'lie down until the dizziness passes, then get up slowly.\r\nmove slowly and carefully.\r\nget plenty of rest.\r\ndrink plenty of fluids, especially water.\r\navoid coffee, cigarettes, alcohol and drugs.\r\n\r\nPotential illnesses: Benign Paroxysmal Positional Vertigo, Meniere\'s Disease, Vestibular Migraine, Dehydration.', 'استلقِ حتى تزول الدوخة ، ثم استيقظ ببطء.\r\nتحرك ببطء وحذر.\r\nالحصول على الكثير من الراحة.\r\nاشرب الكثير من السوائل وخاصة الماء.\r\nتجنب القهوة والسجائر والكحول والمخدرات.\r\n\r\nالأمراض المحتملة: دوار الوضعة الانتيابي الحميد ، مرض مينيير ، الصداع النصفي الدهليزي ، الجفاف.', 'allongez-vous jusqu\'à ce que le vertige passe, puis levez-vous lentement.\r\ndéplacez-vous lentement et prudemment.\r\nreposez-vous bien.\r\nbuvez beaucoup de liquides, surtout de l\'eau.\r\névitez le café, les cigarettes, l\'alcool et les drogues.\r\n\r\nMaladies potentielles : vertige positionnel paroxystique bénin, maladie de Ménière, migraine vestibulaire, déshydratation.', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
(4, 'itching.png', 'Itching', 'الحكه', 'Démangeaison', 'Apply a cold, wet cloth or ice pack to the skin that itches. Do this for about five to 10 minutes or until the itch subsides.\r\nApply topical anesthetics that contain pramoxine.\r\nApply cooling agents, such as menthol or calamine.\r\n\r\nPotential illnesses: dry skin (xerosis),eczema (dermatitis),psoriasis, scabies,parasites, burns, scars, insect bites and hives.', 'ضع قطعة قماش مبللة أو قطعة من الثلج على الجلد الذي يسبب الحكة. افعل ذلك لمدة خمس إلى 10 دقائق أو حتى تهدأ الحكة.\r\nاستخدم التخدير الموضعي الذي يحتوي على براموكسين.\r\nضع عوامل التبريد ، مثل المنثول أو الكالامين.\r\n\r\nالأمراض المحتملة: جفاف الجلد (جفاف) ، الأكزيما (التهاب الجلد) ، الصدفية ، الجرب ، الطفيليات ، الحروق ، الندبات ، لدغات الحشرات والشرى.', 'Appliquez un chiffon froid et humide ou un sac de glace sur la peau qui démange. Faites cela pendant environ cinq à 10 minutes ou jusqu\'à ce que les démangeaisons disparaissent.\r\nAppliquez des anesthésiques topiques contenant de la pramoxine.\r\nAppliquez des agents de refroidissement, tels que le menthol ou la calamine.\r\n\r\nMaladies potentielles : peau sèche (xérose), eczéma (dermatite), psoriasis, gale, parasites, brûlures, cicatrices, piqûres d\'insectes et urticaire.', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 'red-eye.png', 'Red Eye', 'عين حمراء', 'Yeux rouges', 'Rest.\r\nCool compresses over closed eyes.\r\nLightly massaging your eyelids.\r\nGently washing your eyelids.\r\nOver-the-counter eye drops.\r\n\r\nPotential illnesses:glaucoma.\r\nblepharitis.\r\ncellulitis.\r\neye lymphoma.\r\nherpes zoster (shingles)\r\ntoxoplasmosis.\r\nuveitis.', 'استراحة.\r\nكمادات باردة على العيون المغلقة.\r\nقم بتدليك جفونك برفق.\r\nاغسل جفونك بلطف.\r\nقطرات العين التي لا تستلزم وصفة طبية.\r\n\r\nالأمراض المحتملة: الجلوكوما.\r\nالتهاب الجفن.\r\nالنسيج الخلوي.\r\nسرطان الغدد الليمفاوية في العين.\r\nالهربس النطاقي (القوباء المنطقية)\r\nداء المقوسات.\r\nالتهاب القزحية.', 'Repos.\r\nCompresses fraîches sur les yeux fermés.\r\nMassez légèrement vos paupières.\r\nLavez doucement vos paupières.\r\nGouttes pour les yeux en vente libre.\r\n\r\nMaladies potentielles : glaucome.\r\nblépharite.\r\ncellulite.\r\nlymphome oculaire.\r\nzona (zona)\r\ntoxoplasmose.\r\nuvéite.', 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 'runny-nose.png', 'Runny Nose', 'سيلان الأنف', 'Nez qui coule', 'Rest.\r\nDrink plenty of fluids, especially water.\r\nUse a saline nasal spray to help relieve symptoms.\r\nA cool-mist humidifier at your bedside can combat congestion worsened by dry winter air.\r\n\r\nPotential illnesses:colds, flu or sinusitis', 'استراحة.\r\nاشرب الكثير من السوائل ، وخاصة الماء.\r\nاستخدم بخاخ محلول ملحي للأنف للمساعدة في تخفيف الأعراض.\r\nيمكن لمرطب الهواء بالرذاذ البارد الموجود بجانب سريرك أن يقاوم الازدحام الذي يتفاقم بفعل هواء الشتاء الجاف.\r\n\r\nأمراض محتملة: نزلات البرد والأنفلونزا والتهاب الجيوب الأنفية', 'Repos.\r\nBuvez beaucoup de liquides, surtout de l\'eau.\r\nUtilisez un vaporisateur nasal salin pour aider à soulager les symptômes.\r\nUn humidificateur à vapeur froide à votre chevet peut lutter contre la congestion aggravée par l\'air sec de l\'hiver.\r\n\r\nMaladies potentielles : rhume, grippe ou sinusite', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 'sick.png', 'fever', 'مصاب بالبرد', 'avoir froid', 'rest and sleep.\r\ndrink plenty of water (fruit juice or squash mixed with water is OK) to avoid dehydration.\r\ngargle salt water to soothe a sore throat (not suitable for children)\r\n\r\nPotential illnesses:Hypothermia,Trench Foot,Chilblains.', 'الراحة والنوم.\r\nشرب الكثير من الماء (عصير الفاكهة أو القرع الممزوج بالماء لا بأس به) لتجنب الجفاف.\r\nالغرغرة بالماء المالح لتسكين التهاب الحلق (غير مناسب للأطفال)\r\n\r\nالأمراض المحتملة: انخفاض حرارة الجسم ، قدم الخندق ، تورم الأصابع.', 'repos et sommeil.\r\nbuvez beaucoup d\'eau (du jus de fruit ou de la courge mélangée à de l\'eau est OK) pour éviter la déshydratation.\r\nse gargariser d\'eau salée pour apaiser un mal de gorge (ne convient pas aux enfants)\r\n\r\nMaladies potentielles : hypothermie, pied de tranchée, engelures.', 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
(8, 'sneezing.png', 'Sneezing', 'العطس', 'éternuement', 'Eating honey might help with seasonal allergies that might be causing you to sneeze. \r\nTurmeric. \r\nBlack Pepper. \r\nGinger. \r\nUsing Air Filters. \r\nProper Washing of the Beddings and Sheets. \r\nPet Care. \r\nAvoiding Outdoor Exposure.\r\n\r\nPotential illnesses:Allergy to pollen (hay fever), mold, dander, dust,cold or the flu.', 'قد يساعد تناول العسل في علاج الحساسية الموسمية التي قد تسبب لك العطس.\r\nكُركُم.\r\nفلفل اسود.\r\nزنجبيل.\r\nاستخدام مرشحات الهواء.\r\nالغسل السليم للمفارش والشراشف.\r\nرعاية الحيوانات الاليفة.\r\nتجنب التعرض في الهواء الطلق.\r\n\r\nالأمراض المحتملة: حساسية من حبوب اللقاح (حمى القش) ، العفن ، وبر ، الغبار ، البرد أو الأنفلونزا.', 'Manger du miel peut aider avec les allergies saisonnières qui pourraient vous faire éternuer.\r\nCurcuma.\r\nPoivre noir.\r\nGingembre.\r\nUtilisation de filtres à air.\r\nLavage correct de la literie et des draps.\r\nS\'occuper d\'un animal.\r\nÉviter l\'exposition à l\'extérieur.\r\n\r\nMaladies potentielles : allergie au pollen (rhume des foins), aux moisissures, aux squames, à la poussière, au rhume ou à la grippe.', 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 'tongue.png', 'Unable to taste', 'غير قادر على التذوق', 'Impossible de goûter', 'Bacterial sinusitis, salivary gland infections, and throat infections can be treated with antibiotics. Symptoms of colds, flu, and allergic rhinitis that impact taste may be relieved with decongestants or antihistamines.\r\n\r\nPotential illnesses:dental problems, cold or flu, and COVID-19.', 'يمكن علاج التهاب الجيوب الأنفية الجرثومي والتهابات الغدد اللعابية والتهابات الحلق بالمضادات الحيوية. يمكن تخفيف أعراض نزلات البرد والإنفلونزا والتهاب الأنف التحسسي التي تؤثر على التذوق باستخدام مضادات الاحتقان أو مضادات الهيستامين.\r\n\r\nالأمراض المحتملة: مشاكل الأسنان ، البرد أو الأنفلونزا ، و COVID-19.', 'La sinusite bactérienne, les infections des glandes salivaires et les infections de la gorge peuvent être traitées avec des antibiotiques. Les symptômes du rhume, de la grippe et de la rhinite allergique qui affectent le goût peuvent être soulagés avec des décongestionnants ou des antihistaminiques.\r\n\r\nMaladies potentielles : problèmes dentaires, rhume ou grippe et COVID-19.', 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
(10, 'vomit.png', 'vomitting', 'القيء', 'vomir', 'Drink clear or ice-cold drinks. Eat light, bland foods (such as saltine crackers or plain bread). Avoid fried, greasy, or sweet foods. Eat slowly and eat smaller, more frequent meals.\r\n\r\nPotential illnesses:Gastroenteritis. If you have diarrhoea as well as vomiting, it\'s likely you have gastroenteritis. \r\nPregnancy. \r\nMigraines. \r\nLabyrinthitis. \r\nMotion sickness. \r\nAppendicitis.', 'اشرب مشروبات صافية أو مثلجة. تناول أطعمة خفيفة وخفيفة (مثل البسكويت المملح أو الخبز العادي). تجنب الأطعمة المقلية أو الدهنية أو الحلوة. تناول الطعام ببطء وتناول وجبات صغيرة ومتكررة.\r\n\r\nالأمراض المحتملة: التهاب المعدة والأمعاء. إذا كنت تعاني من الإسهال والقيء ، فمن المحتمل أنك مصاب بالتهاب المعدة والأمعاء.\r\nحمل.\r\nالصداع النصفي.\r\nالتهاب تيه الأذن.\r\nدوار الحركة.\r\nالتهاب الزائدة الدودية.', 'Buvez des boissons claires ou glacées. Mangez des aliments légers et fades (comme des craquelins salés ou du pain ordinaire). Évitez les aliments frits, gras ou sucrés. Mangez lentement et mangez des repas plus petits et plus fréquents.\r\n\r\nMaladies potentielles : Gastro-entérite. Si vous souffrez de diarrhée et de vomissements, il est probable que vous ayez une gastro-entérite.\r\nGrossesse.\r\nMigraines.\r\nLabyrinthite.\r\nMal des transports.\r\nAppendicite', 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `symptoms`
--

CREATE TABLE `symptoms` (
  `illness_id` int(11) NOT NULL,
  `headache` tinyint(1) NOT NULL DEFAULT 0,
  `runny_nose` tinyint(1) NOT NULL DEFAULT 0,
  `itching` tinyint(1) NOT NULL DEFAULT 0,
  `red_eyes` tinyint(1) NOT NULL DEFAULT 0,
  `sneezing` tinyint(1) NOT NULL DEFAULT 0,
  `throat` tinyint(1) NOT NULL DEFAULT 0,
  `fever` tinyint(1) NOT NULL DEFAULT 0,
  `tired` tinyint(1) NOT NULL DEFAULT 0,
  `taste` tinyint(1) NOT NULL DEFAULT 0,
  `vomitting` tinyint(1) NOT NULL DEFAULT 0,
  `dizziness` tinyint(1) NOT NULL DEFAULT 0,
  `diarrhea` tinyint(1) NOT NULL DEFAULT 0,
  `stomach` tinyint(1) NOT NULL DEFAULT 0,
  `blood` tinyint(4) NOT NULL DEFAULT 0,
  `heart` tinyint(4) NOT NULL DEFAULT 0,
  `coughing` tinyint(4) NOT NULL DEFAULT 0,
  `pee` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `symptoms`
--

INSERT INTO `symptoms` (`illness_id`, `headache`, `runny_nose`, `itching`, `red_eyes`, `sneezing`, `throat`, `fever`, `tired`, `taste`, `vomitting`, `dizziness`, `diarrhea`, `stomach`, `blood`, `heart`, `coughing`, `pee`) VALUES
(1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
(5, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0),
(9, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
(10, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
(11, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
(13, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0),
(14, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(15, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(16, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0),
(17, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0),
(19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0),
(20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
(21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `input` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`input`) VALUES
('hi'),
(''),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
('how are you'),
(''),
(''),
(''),
(''),
(''),
(''),
(''),
(''),
('hi'),
('hi'),
('batata'),
('batata'),
('batata'),
('batata'),
('batata'),
(''),
('test'),
('test'),
('Hi how are you'),
('hi'),
('hi'),
('hi'),
('I have headache'),
('I have headache'),
('hi'),
('I have headache'),
('راسي يؤلمني'),
('كرشي توجع من البارح'),
('I have headache'),
('means'),
('means'),
('I have headache'),
('I have headache'),
('I have headache'),
('today I\'ve been a continents accidents they have headache now'),
('I have headache'),
('I have headache I have been in accident'),
('I have headache and I have been in an accident'),
('I have headache and I was in an accident'),
('I have headache');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `apikey` varchar(255) DEFAULT NULL,
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `apikey`, `image`) VALUES
(133, 'fdsaf', 'fdasf', NULL, ''),
(135, 'fdsaffdsa', 'fdasf', NULL, ''),
(141, 'fdsaffdsafdsa', 'fdasf', NULL, ''),
(142, 'fdsaffdsafdsahgf', 'fdasf', NULL, ''),
(144, 'fdsaffdsafdsahgffdas', 'fdasf', NULL, ''),
(145, 'fdsaffdsafdsahgffdashjg', 'fdasf', '', ''),
(146, 'fsdaafaf', 'fdasfas', NULL, ''),
(147, 'wsup', 'nigga', '', ''),
(148, 'nigga', 'ass', '', ''),
(149, 'hello', 'nigga', '', ''),
(150, 'farouk@gmail.com', '12345678', '', ''),
(151, 'fff', 'fff', '', ''),
(152, 'ffff', 'fff', '', ''),
(153, 'fffff', 'fffff', NULL, ''),
(154, 'rrr', 'rrr', NULL, ''),
(155, 'ffffff', 'ffffff', NULL, ''),
(156, 'asd', 'fdas', NULL, ''),
(157, 'dfasfasdf', 'dfasfasdf', NULL, ''),
(158, 'gfdsgsd', 'gfdsgsdgfds', NULL, ''),
(166, 'gfdsgsdgdfsg', 'gfdsgsdgfdsgfsd', NULL, ''),
(169, 'gfdsgsdf', 'gfsdgdfsg', '', 'images/28-04-2023 -1682718207-10000.jpg'),
(170, 'gdsafa', 'fdasfa', NULL, 'images/28-04-2023 -1682718288-10000.jpg'),
(171, 'gadsasdga', 'dasgasdf', NULL, 'images/28-04-2023 -1682718319-10000.jpg'),
(172, 'fdasf', 'fdasfa', NULL, 'images/28-04-2023 -1682718475-10000.jpg'),
(179, 'fdasffdas', 'fdasfa', NULL, 'images/28-04-2023 -1682718608-10000.jpg'),
(181, 'bitchass', 'nigga', '', 'images/28-04-2023 -1682718706-10000.jpg'),
(183, 'farouk', 'aissi', '', 'images/29-04-2023-1682754892-10000.jpg'),
(185, 'hhhhh', 'hhhhh', 'b912962d205ad1c6c595aa592bc1d0596bf38d9b898cc9', 'images/29-04-2023-1682766765-10000.jpg'),
(186, 'zouak', 'farouk', NULL, 'images/03-05-2023-1683129934-10000.jpg'),
(191, 'zaouak', 'farouk', NULL, 'images/03-05-2023-1683130125-10000.jpg'),
(194, 'zaouakk', 'faroukk', NULL, 'images/03-05-2023-1683130205-10000.jpg'),
(195, 'zaouakks', 'faroukk', '', 'images/03-05-2023-1683130272-10000.jpg'),
(196, 'dfsaljk', 'dgadf', NULL, NULL),
(206, 'ahmedmm', '12345678', '', 'images/19-05-2023-1684508767-10000.jpg'),
(208, 'niggaass', '$2y$10$Zo3vhCC21S7rzpyx/NW8R.K4GFjs6ukWF9RUU/OVfgow3D1j3i0SC', 'b13a2700d3fcebd09b269f37233ef73b8a48f688f8f2d4', 'images/22-05-2023-1684784923-10000.jpg'),
(209, 'faroukkk', '$2y$10$snoIMimuv.CTAQatQSm8IOsXUQqE2BMqqIyUf6zgxVUL1xIoFEJlu', '', NULL),
(210, 'fzouak24@gmail.com', '$2y$10$z6l5ITMQlF5JX/LHOwjBauU50h3Fjc6GtWirhf0HF5xHiw72gVDtW', 'd1180af2307318cb4baf1971829b1d6e8751f79fb59d82', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `help`
--
ALTER TABLE `help`
  ADD PRIMARY KEY (`illness_id`);

--
-- Indexes for table `illness`
--
ALTER TABLE `illness`
  ADD PRIMARY KEY (`illness_id`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `pdf_data`
--
ALTER TABLE `pdf_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recent`
--
ALTER TABLE `recent`
  ADD PRIMARY KEY (`diagnose_id`);

--
-- Indexes for table `simple_symptoms`
--
ALTER TABLE `simple_symptoms`
  ADD PRIMARY KEY (`symptom_id`);

--
-- Indexes for table `symptoms`
--
ALTER TABLE `symptoms`
  ADD PRIMARY KEY (`illness_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `pdf_data`
--
ALTER TABLE `pdf_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `recent`
--
ALTER TABLE `recent`
  MODIFY `diagnose_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=279;

--
-- AUTO_INCREMENT for table `simple_symptoms`
--
ALTER TABLE `simple_symptoms`
  MODIFY `symptom_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=212;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `help`
--
ALTER TABLE `help`
  ADD CONSTRAINT `illness_fk` FOREIGN KEY (`illness_id`) REFERENCES `illness` (`illness_id`);

--
-- Constraints for table `info`
--
ALTER TABLE `info`
  ADD CONSTRAINT `FKinfo822494` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Constraints for table `symptoms`
--
ALTER TABLE `symptoms`
  ADD CONSTRAINT `illness_fk_symptom` FOREIGN KEY (`illness_id`) REFERENCES `illness` (`illness_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
