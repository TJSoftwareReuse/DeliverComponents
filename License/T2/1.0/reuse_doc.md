# License Manager 复用文档
### 总体描述
1. 构件名称：LicenseManager
2. 构建功能：该组件用于客户端向系统申请证书资源，并且保证该申请过程是线程安全的。系统的证书资源有一个上限，当证书的申请数并未超过系统证书上限时，客户端的证书申请有效。否则客户端的证书申请将无效。
3. 使用步骤：
该组件使用LicenseManager类来对证书申请进行操作，客户端向系统申请证书资源的步骤如下：

	* 首先我们需要获得LicenseManager实例，代码如下：

			import com.license.manager.LicenseManager;
			LicenseManager licenseManager = LicenseManager.getInstance(); 


	* 客户端需要将自身的一些信息填入CallerMessage类中（当前类中仅包含客户端ID字段信息），使得系统了解证书的申请者信息，操作代码如下：
	
			import com.license.caller.CallerMessage;
			CallerMessage callerMessage = new CallerMessage(“THFERDXEWWS-98754456”);// THFERDXEWWS-98754456为申请证书资源客户端的ID号。

	* 通过LicenseManager向系统发起证书申请，代码如下：
	
			import com.license.manager.message.RequestResultMessage;
			RequestResultMessage rrm = licenseManager.requestLicense(callerMessage);
	
4. 说明：
	* ```LicenseManager```的```requestLicense```方法要求客户端传入一个```CallerMessage```类的实例，该实例中包含了发出证书申请客户端的一些信息。随后向系统发出证书申请，该方法将会返回一个```RequestResultMessage```对象，该对象中包含了证书申请成功与否的信息。如上，可调用```RequestResultMessage```的```isSuccess()```方法来判断此次证书申请过程是否成功。若```isSuccess()```返回```True```，那么表示此次证书申请成功；否则，证书申请失败。
	* 当```RequestResultMessage```的```isSuccess()```返回```False```时，我们可以调用```RequestResultMessage```的```getInfo()```方法来获取证书申请失败的相关信息。如果该信息为"Request License Failed"，那么说明此时系统的证书资源已经耗尽。若该信息为"License Request Exception，Error Message：……"，那么说明此时系统资源仍有剩余，问题出在客户端向系统申请资源的过程中，具体的出错原因由```getInfo()```获得的Exception信息具体判断。另外还可通过RequestResultMessage的getResponseTime()方法获得系统对证书申请做出回馈的时间。
5. 下面给出一个简单的示例:

		import com.license.caller.CallerMessage;
		import com.license.manager.LicenseManager;
		import com.license.manager.message.RequestResultMessage;

		public class TestLicense {
			public static void main(String[] args){
				//1. 获得LicenseManager实例，用于接下来的证书申请操作。
				LicenseManager licenseManager = LicenseManager.getInstance();
				//2. 生成CallerMessage实例，填充做出证书申请客户端的一些基本信息。
				CallerMessage callerMessage = new CallerMessage("THFERDXEWWS-98754456");
				//3. 向系统发起证书申请操作。
				RequestResultMessage rrm = licenseManager.requestLicense(callerMessage);
				//4. 检查此次证书申请是否成功。
				if(rrm.isSuccess()){//证书申请成功
					System.out.println("证书申请成功，申请时间："+rrm.getResponseTime());
				}else{//证书申请失败
					System.out.println("证书申请失败，出错信息："+rrm.getInfo()+", 申请时间："+rrm.getResponseTime());
				}
			}
		}



