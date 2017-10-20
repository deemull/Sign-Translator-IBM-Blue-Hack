import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions.Tone;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;



public class Options extends JFrame {

	private JPanel helloPanel;
	private JLabel hello;
	
	private JPanel signTranslator;
	
	private JPanel languageTranslator;
	
	private JPanel toneAnalyzer;
	
	private JPanel exitPanel;
	
	

	public Options()
	{
		setTitle("Sign and Language Translator");
		setLayout(new GridLayout(5,1));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildHelloPanel();
		buildSignTranslator();
		buildLanguageTranslator();
		buildToneAnalyzer();
		buildExitButton();
		add(helloPanel);
		add(signTranslator);
		add(languageTranslator);
		add(toneAnalyzer);
		add(exitPanel);
		pack();
		setVisible(true);
	}
	
	private void buildHelloPanel()
	{
		helloPanel = new JPanel();
		hello = new JLabel("Hello There! Selection your option");
		helloPanel.add(hello);
	}
	
	private void buildSignTranslator()
	{
		signTranslator = new JPanel();
		ImageIcon signButtonImage = new ImageIcon("images\\signButtonImage.jpg");
		JButton signTranlatorButton = new JButton("Sign Tranlator", signButtonImage);   
		signTranlatorButton.addActionListener(new SignTranslationListener());
		signTranslator.add(signTranlatorButton);
		
	}
	
	private void buildLanguageTranslator()
	{
		languageTranslator = new JPanel();
		ImageIcon languageTranslatorImg = new ImageIcon("images\\lTranslatorImg.jpg");
		JButton languageTranslatorButton = new JButton("Language Tranlator",languageTranslatorImg);
		languageTranslatorButton.addActionListener(new LanguageTranslatorListener());
		languageTranslator.add(languageTranslatorButton);
			
	}
	
	private void buildToneAnalyzer()
	{
		toneAnalyzer = new JPanel();
		ImageIcon toneAnalyzerImg = new ImageIcon("images\\toneAnalyzerImg.jpg");
		JButton languageTranslatorButton = new JButton("Tone Analyzer",toneAnalyzerImg);
		languageTranslatorButton.addActionListener(new ToneAnalyzerListener());
		languageTranslator.add(languageTranslatorButton);
			
	}
	
	private void buildExitButton()
	{
		exitPanel = new JPanel();
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ExitListener());
		exitPanel.add(exit);
	}
	
	private class SignTranslationListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			VisualRecognition service = new VisualRecognition(
					  VisualRecognition.VERSION_DATE_2016_05_20
					);
			
					service.setApiKey("cf1dd02eac61a052564bb5a11b831161cfe607da");
		
					String filename = null;
					
					InputStream imagesStream = null;
					try {
						JFileChooser choose = new JFileChooser();
			    		int pick = choose.showOpenDialog(null);
			    		
			    		if(pick == JFileChooser.APPROVE_OPTION)
			    		{
			    			File selectedFile = choose.getSelectedFile();
			    			
			    			filename = selectedFile.getPath();
			    		
			    			
						imagesStream = new FileInputStream(filename);
			    		}
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "Error Opening file! ");
						e.printStackTrace();
					}
					ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
					  .imagesFile(imagesStream)
					  .imagesFilename(filename)
					  .parameters("{\"classifier_ids\": [\"tranlatesignstotexts_485033682\"],"
					    + "\"owners\":[\"2c241ba5-cd5d-498d-9364-156d7d38953b\"], \"threshold\": \"0.1\"}")
					  .build();
					
					JsonObject json = new JsonObject();
					//json.get(memberName);
					
					ClassifiedImages result = service.classify(classifyOptions).execute();
					JOptionPane.showMessageDialog(null, result);
		}
		
	}
	
	private class LanguageTranslatorListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String textToTranslate = JOptionPane.showInputDialog("Enter the text you want to translate");
			
			LanguageTranslator service = new LanguageTranslator();
			service.setUsernameAndPassword("36982478-b921-4cf1-a5eb-1863bfcc3d33","EujOGNXzsLNx");

			//TranslationResult result = service.translate(textToTranslate,"es");
			//JOptionPane.showMessageDialog(null, result);
			
			
			/*LanguageTranslator service = new LanguageTranslator();
			service.setUsernameAndPassword("36982478-b921-4cf1-a5eb-1863bfcc3d33","EujOGNXzsLNx");

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", "custom-english-to-spanish");
			params.put("base_model_id", "en-es");
			params.put("forced_glossary", new File("glossary.tmx"));

			TranslationModel model = service.createModel(params);
			System.out.println(model);*/
			
		}
		
	}
	
	private class ToneAnalyzerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ToneAnalyzer service = new ToneAnalyzer("{version}");
			service.setUsernameAndPassword("{username", "{passsord}");

			try {
			  JsonReader jReader = new JsonReader(new FileReader("tone.json"));
			  JsonParser jParser = new JsonParser();
			  JsonObject jObject = (JsonObject) jParser.parse(jReader);
			  ToneOptions options = new ToneOptions.Builder()
			    .addTone(Tone.EMOTION).build();
			  //ToneAnalysis tone =
			    //service.getTone(jObject.get("text").getAsString(), options).execute();
			  //System.out.println(tone);
			} catch (FileNotFoundException e) {
			  e.printStackTrace();
			}
		}
		
	}
	
	private class ExitListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
	
}
