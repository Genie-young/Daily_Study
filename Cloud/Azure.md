# Azure



## Module 1.Microsoft Azure

- IP세팅 

  window 실행 - ncpa.cpl - 네트워크 연결 켜짐.

  cmd -> ipconfig /all - 네트워크 설정 확인하기 

  ping 8.8.8.8 => 구글 DNS 서버로 ping 보내기 

- IP 구성

  자동 : DHCP서버 이용(임대 시간을 이용해 오랫동안 사용하지 않는 IP를 다른 컴퓨터에 할당해 효율적으로 IP사용)

  수동 (고정) : IP, Subnet Mask,Gateway, DNS
  
- net use v: \\70.12.113.130\share - 네트워크 공유 명령어

- MS 계정 생성 - siler2312@gmail.com 

- 가상화 구현 

  - Type 1 가상화 (실제 서비스) :MS - Hyper-V, VMware vSphere, Xen, KVM 

    ​	CPU, RAM, HDD, LAN의 가상화 지원, RAM(DEP 지원)

    기존 OS구조는 HW에 locking 이 되어 있어서 하나의 HW는 하나의 OS만 사용 가능 

    동일하게 App은 OS에 lock이 걸려있음  

     => mobility 가 없음. 

    ![1555982496283](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1555982496283.png)

    VM구조는 해당 locking을 해제하여 2개 이상의 OS를 사용 할 수 있게 해줌. 

    ![1555982624267](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1555982624267.png)

    만약 하나의 서버에 vm이 여러개라면(사용자들이 많아지면) 다른 서버로 vm을 이동시킴. 

     => 확장성, 서버의 utilization 을 극대화함. 불필요하면 서버를 사용하지 않음. 

    데이터셋의 elastic성 증진. 

    기존 Unix와 같은 메인 프레임서버는 전기료가 많이 나오지만 중요한 시스템이라 종료할 수 없음. 

    

    ***따라서 가상화를 사용하여 전기료 절감하고 서버를 효율적으로 사용.***

    

  - Type 2 가상화 (테스트, 개발) : Oracle VirtualBox, VMware Player 

    

- Hyper -V : VM을 전체적으로 관리하는 kernal

  - Hyper-V 설치하기 : 제어판\프로그램 - windows 기능 켜기/끄기 - Hyper-V 체크
  - 64비트에서만 가능하고, Home edition에서는 지원안함.	
  - 작업관리자 -> 성능 -> 가상화 사용으로 되어있는 지 확인 
  - 시작 -> Hyper-V관리자 검색, 접속 
  - VM( Virtual Machine ) : Hyper-V 에 설치된 os 
    - Host OS : 실체 H/W에 설치된 os
    - Guewst OS : VM웨어에 설지된 os 

![1555982985453](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1555982985453.png)

- VM 설치하기

  1. WS2019

     - Hyper-V 관리자 -> 이름 및 폴더 지정 -> 새로만들기

     - 네트워킹 - default 스위치

     - 1세대 VM : 바이오스, E-IDE( 0:0 ) <== OS, IDE 컨트롤러, 32bit, 64bit 지원

     - 2세대 VM : 펌웨어( secure booting 가능 ), SCSI <== OS,  스쿼시 컨트롤러, 64bit

     - 가상 하드디스크 연결 - 가상 하드디스크 만들기  -> 이름의 확장자가 .vhdx이어야 함. 

       ​	- vhd : 2008에서 지원 <== Azure로 이동 가능한데 vhd로 변환한 후 이동.   

       ​	- vhdx : 2012, vhd보다 30% 빠름
     
     VM 우클릭 설정 -> IDE 컨트롤러 -> 이미지 파일에 운영체제 파일 넣어주기 -> 확인하고 VM더블클릭해서 실행 
     
     <https://docs.microsoft.com/ko-kr/sysinternals/downloads/ 	// 시스템 관리 툴 
     
      -> Sysinternal Suite 다운 
     
     암호 복잡성 요구 : 대문자, 소문자 ,특수문자, 숫자 중 3가지가 조합된 암호(Domain 환경)
     
     // 작업그룹 환경일 때는 요구하지 않음.  - Pa55w.rd
     
      mstsc /v: 192.168.240.253 or 배치파일 만들기 or 제어판의 원격 데스트톱 접속 - TCP 3389
     
  2. CentOS
  
     리눅스 서버는 putty 를 통해 원격 접속 가능, shutdown -r now
     
  3. 원격관리 
        -Windows : 원격 데스크톱 연결 (TCP 3389) <=GUI
        -Linux      : SSH (TCP 22)		        <=TUI

- 명령어 배치파일로 만들기

   메모장 열어서 명령어를 적고 "파일이름.bat"로 저장하여 파일을 실행하면 해당 명령이 실행됨. 

### L1. Cloud Computing 

1. 클라우드 컴퓨터의 특징

   - 만들어진 서비스를 선택해서 사용 가능 

   - 네트워크로 연결하는 것

   - 자원 pooling( network는 network대로 묶고, storage는 storage대로 묶고, server)

   - elasticity 적게 쓸 때는 적게 , 많이 쓸 때는 큰 장소르 제공 

   - 적은 요금

     

2. Cloud-computing models

   - Private cloud : 온프레미스의 데이터셋을 클라우드로 만듦. 장비들을 pooling할 수 있음. "자체구축"한다는 점이 중요함

   - Public cloud : vendor가 서비스하는 클라우드

   - Hybrid cloud : pivate + public cloud

     

3. Types of cloud services ( 관리 레벨의 차이 )

   - 소프트웨어 정의 데이터센터(Software Defined Data Center, SDDC) - pooling

     Networking, Storage, Servers를 각각 pooling(통합)하여 추상화시켜 관리하는 것을 Private 클라우드라고 함.

     각각 SDN , SDS, SDC(Software Defined Compute) 라고 함. 

   - Iaas( Infrastructure as a Service ) : Servers, Storage, Networking, Virtualization을 vendor가 함. ex) VM

   - Paas( Platform as a Service ) :  Iaas + O/S, Middleware/ Runtime  

   - Saas( Software as a Service ) : Paas +  Data, Application ex) office 365

![1556007409432](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1556007409432.png)



- Host : 네트워크의 장치( 컴퓨터, 프린터, 라우터, 스위치 )

  라우터 : 네트워크의 경계선을 정해줌. 

  Gateway로 패킷을 수송신할 수 있음. 라우터에서 gateway 를 정해줌.  

### L2. Azure?

- Azure Datacenters

  - pairing으로 이루어져있고, 대부분 같은 지역의 counterpart가 있음. 
  - 재난 복구 상황을 대비하기 위해서 pair로 만들어짐.

- Availability 

  - Availability zone 을 셋팅 시 99.99% SLA 보장, 다른 데이터 센터로 복제 
  - Availiability set : 99.95% SLA, 데이터 센터 내의 lack 단위, 하나의 데이터 센터에서의 렉 단위 

- Azure Service : 계산과 저장 서비스를 제공하는 서비스의 집합.

  1. Compute

     Container Instance, Azure Virtual Machines

  2. Networking

     Virtual Network, Traffic Manager, Load Balancer

  3. Data&Storage

     Storage

  4. Web&Mobile

     Web apps

  5. Others

     Azure AD, Site Recovery

- Azure Management Models

  1. Classic(Azure Service Management)

     기존 클래식 모델은 확장성이 좋지 않아 ARM으로 변경됨.

  2. Azure Resource Manager ( ARM )

     관리범위의 개념을 기본으로 함.

     tagging기능을 지원함.

     기본 템플릿을 제공하여 배포 가능

     full RBAC 기능을 지원함.  ( 용어 정리 5번)

### L3. Managing Azure

- Azure portal : https://portal.azure.com

  Azure Account Center : https://account.windowsazure.com

- Azure Management tools

  - powershell : 동사 + 명사  //window powershell메뉴
  - CLI : set of command    //window의 cmd 창에서 사용 
  - cloud shell : 포털에서 사용하는 shell  - powershell or bash 사용 가능, 별도의 인증 과정 필요 없음,  애저 저장소에 있는 file share가 필요함.
  - Visual Studio with Azure SDKs
  - Azure Cloud Shell
  - Azure Security Center
  - Azure Advisor
  - Azure Monitor

- Private IP의 1~3은 azure가 사용, 사용자는 4부터 255까지 사용 가능 

  IP forwarding : 공인 IP로 접속하면 사설 ip로 변경해주는 활동  //NAT 규칙에 의거함.
  
  

------


## Module 2. management tools

- PowerShell, CLI를 사용하면 대량관리, 자동화, 스크립트화 가능함. 
- GUI는 단순하게 한 개의 작업을 하기 좋음. 

### L1. Powershell

1) poweshell 개요

- PowerShell : 간단하게 사용 가능. 스크립트 파일 실행 가능, but 만들기 x

- PowerShell ISE : GUI인데 작업했더 것을 저장해서 스크립트화 가능.

- Visual Studio도 powerShell로 관리 가능, 관련 module을 설치 해야함.

- powerShell은 모듈화가 되어 있음. 

  - 모듈 - powerShell의 명령어들의 집합.
  - 모듈 설치 및 등록 필요.
    - $env:PSModulePath  모듈이 설치된 위치 확인 명령어

- $변수명 = 값

- 명령어는 동사-명사로 이루어짐.

- 주석은 #, <# #>

- 명령어를 어느정도 타이핑 후 ctrl + space 하면 자동완성

- powerShell을 통해 Azure에 접근해서 사용할 수 있도록 인증을 해줘야함.

  1) 인증 

  ```powershell
  #계정 접속 
  Connect-AzureRmAccount 					 #ARM 접속 시 - 명령어에 Rm이 포함됨.
  Add-AzureAccount					     #Service Management
  ```

  2) target subscription을 정함.       //주의 subscription을 잘못 지정하면 잘못 삭제할 수 있으니 두 번 체크

  ```powershell
  Get-AzureRmSubscription                   #구독 내용 확인 
  Select-AzureRmSubscription                #구독 선택
  ```

2) Module 개요

 local의 PowerShell 사용 시에 각각의 모듈을 import해야 사용 가능. CloudShell에서는 바로 사용 가능

- 기능 구분 : Resourc Manager, Service Management, Active Directory, Rights Management, Service Fabric
- 설치 : PowerShellGet(win.linux, mac), WEB PI(win), MSI package(win)

3)Module

- Azure Resource Manager : 확장 관리 가능 

  ```powershell
  Connect-AzAccount 					#계정 인증
  Get-AzSubscription                   #구독 내용 확인 
  Select-AzSubscription                #구독 선택
  ```

  

- Service Management( classic ) : ARM의 옛날 버전 

  ```powershell
  Add-AzureAccount					     #계정 인증
  Get-AzureSubscription					 #구독 내용 확인
  Select-AzureSubscription				 #구독 선택 
  ```

4) Azure Module설치  //문서에 Azure_Module_Install.ps1 스크립트 파일 만듦.

https://docs.microsoft.com/en-us/powershell/azure/install-az-ps?view=azps-1.8.0&viewFallbackFrom=azps-1.2.0

```powershell
Install-Module -Name Az -AllowClobber	     #Azure 모듈 설치하기, 예, 모두예 선택
Get-ExecutionPolicy						   #보안정책 설정 확인. //Restricted(*.ps1 파일 제한)
Set-ExecutionPolicy Unrestricted             #실행 정책 등급을 Unrestricted로 변경
Import-Module Az.Accounts                    #모듈 import
Connect-AzAccount                            #Azure 계정과 연동하기 

```



- 명령어

  ```powershell
  get-command | more			#명령어를 가져와라, | 의미는 앞의 명령어를 실행해서 뒤에 전달해라
  cls						   #화면 지우기
  get-help get-process 		#get-help 알고싶은 명령어 명령어에 대한 정보를 보여줌. 
  get-module				   #설치된 모듈 확인
  Get-AzSubscription		    # 구독확인
  Select-AzSubscription -Subscription <# 아이디 #> #구독 선택 
  ```

4) Powershell 보안 정책

- Restricted : 제한됨(*.ps1 파일)
- Unrestricted : 실행(보안상 위험)    //원격에서 명령어 실행 가능.
- AllSigned
- Bypass
- Default
- RemoteSigned
- Undefined

5)PowerShell IDE

![1556504825313](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1556504825313.png)



### L2. CLI

- PowerShell에 비해 명령어가 간결하고 쉬움. 

- Linux bash에서 운영.

- Azure CLI 1.0 - **azure**로 명령어가 시작함. ARM, classic 환경 모두 적용 가능.

  Azure CLI 2.0 - **az**로 명령어가 시작함.

- 리눅스 스크립팅 도구와 연동 가능 

- cmd 창에서 실행함.

- 인증

  ```bash
  az login						#장치 인증
  azure config mode arm			 #ARM 관리
  azure config mode asm			 #classic 관리
  ```

- 명령어

  ```bash
  az login					   #로그인
  az account list				   #구독 목록 확인
  az account set --subscription 아이디  #구독 선택하기
  ```

  

LAB SETTING 

- virtual Network (Hyper-V switch 구성)


가상 스위치 관리자 ==> 가상스위치 만들기 : 개인 ==> 가상스위치 만들기 Private Network

10979 mia-cl1 파일 설치 => 기본 경로를 C로만 변경 후 위치 저장 //VM이 설치되는 장소 ==> 설치

C:\Program Files\Microsoft Learning 아래 Base폴더 생성 ==> Base18A-W10-1709.vhd 를 해당 폴더로 옮김.

10979E-scripts.exe 파일 실행시키기

Drives ==> create Virtual -> VM-Pre-Import-10979E.ps1 -> import순으로 관리자로 실행

baseimage => c , c, enter키

 533 -> MIA cl1 파일 설치 ==> 기본 경로를 C로만 변경 후 위치 저장 

script도 풀기



우클릭 => 설정> 하드웨어 추가 => 네트워크 어댑터 default swich로 추가 : NAT면서 이걸로 인터넷으로 나감.

20533 cmd ping 8.8.8.8

ipconfig /all





------

## Module 3. Virtual machine

- 가상 디스크 타입 (확장자 vhd(2T), vhdx(64T, 백업 기능 있음), vhds)\

  실제 서비스는 고정디스크로, 테스트나 개발은 동적 확장, 차이점 보관용 

  - 고정 디스크 : 80GB로 만들 경우 ~~80GB~~

  - 동적 확장 : 80GB로 만들 경우 4MB -> 80GB

  - 차이점 보관용 : Base에서 변경된 내용만 저장 

    

### L1.  Azure VMs

- 확장 가능, 온프레미스에서 다른 클라우드로 이동 가능, 제품 런칭, 테스트, 개발 가능 

- Azure VM의 특징

  -  2세대 Hyper-V 를 지원하지 않음. 
  - .vhdx 파일 포맷 지원안함. 
  - 동적 확장이나 디스크를 바꾸는 것이 허용안됨.
  - 읽기 전용 VM을 만들 수 있다. 

-  VM size

  - general purpose : 메모리와 cpu의 밸런스를 맞춘 VM
  - Burstable(B) : CPU를 적게 씀.
  - Compute optimized(F, Fs, F sv2) : 높은 cpu와 메모리 
  - Memory Optimized : 높은 메모리와 cpu의 조화
  - Storage optimized : high performance
  - GPU support
  - High performance compute(H)  : 가장 빠른 CPU, 
  - ![1556101732882](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1556101732882.png)

  

- 3 fault 도메인(3개의 렉)에 분산해서 저장, 따라서 하나의 전원이 끊겨도 다른 도메인에서 서비스 가능하도록 함.  update 도메인은 패치 이후에 리부팅하는 단위를 update 도메인이라고 함. 지속적인 서비스 가능 

- VM 접근하기

  - Windows VMs : RDP(TCP 3389번 포트)를 통해 접근 가능

  - Linux VMs : SSH( TCP 22번 포트 )로 명령어로 접근, RDP 그래픽 환경으로 접근.

  - portal에서 해당 가상 머신으로 접속 한 후 왼쪽 탭에서 네트워킹을 선택하면 

    방화벽 설정 가능. 보통 방화벽은 들어오는 패킷에 대해서 적용하고 나가는 패킷에 대한 규칙을 심히 지정하지는 않는 편. 



### L2. VM storage

- Azure VM storage

  - C:\  - 기본 드라이브, OS 설치

  - D:\  - 기본 드라이브, 임시 디스크, 데이터가 저장되지 않음. 

    페이지 파일을 저장하여 가상 메모리 영역이라고 할 수 있음. (용어 정리 7번)

  - F:\  - 추가적인 드라이브


- azure 리눅스 VM 접속하기 

  yes 입력 -> 비밀번호 입력 





------

## Modlue 5. Azure networking

<https://docs.microsoft.com/ko-kr/azure/virtual-machines/windows/acu>

###  

1.  DNS database : DNS zone 이라고 부름.

   - 레코드 <== zone 내에서 작업하는 실제 작업을 처리하는 것. zone은 레코드의 집합 

     

   네트워크, 서버, 스토리지

2. Azure virtual Network 

   - 사설 ip 사용하고, 공인 ip는 별도로 매칭, VM은 private를 먼저 사용하고 공인 ip는 필요하다면 구매하여 매칭하면 됨.

   - subnet0     10.10.0.0/24    일때 사용가능한 주소 개수는 251이다. 1,2,3은 애저에서 사용하기 때문

   - 또한 /29 까지 분할 가능.  => /29일 때 ( 8-5=) 3 개의  주소를 사용 

   - Azure에서는 Router가 없이 subnet끼리 통신 가능함.또한 라우터를 넣어서 통신할 수 있도록 설정도 가능 

     일반적으로 subnetting을 하려면 local에서는 물리적인 router가 필요함

   - DNS를 자동구성하나, 커스터마이징 가능

     1) zone을 만들어야 함.

     2) zone에서 레코드(A, CNAME etc) 

     3) 도메인 신청 - zone 4개 중 2개 입력

     만약 직접 DNS를 한다고 생각하면 1) 서버구매 2) OS 세팅 3) DNS 서버 올리기 4) 패치, 보안관리

     DNS서버 위에서 AD, Web, FTP, 메일 서비스 등이 작동되기 때문에 해당 서비스들을 이용 못함.

     따라서 DNS 서버를 중복으로 생성 필수   //Azure는 zone을 4개 복제함.  

   - TCP, UDP, ICMP(ping을 보내는 프로토콜..?) 사용 가능 

     - VM에 접근하기 전에 azure에 방화벽(NSG)이 있음. 따라서 vm방화벽과 NSG를 모두 열어줘야 함.

   - 다수의 IP subnets으로 분리 가능 

   - Private IP를 사용, RFC 1918 기반

     - 10.0.0.0 ~ 10.255.255.255
     - 172.31.0.0 ~ 172.31.255.255
     - 192.168.0.0 ~ 192.168.255.255

   - Vnet간의 통신 or 온프레미스 간의 통신도 지원함. 

3. Azure Vnet의 조건

   1. Vnet 이 필수인 서비스 

      - Azure VMs
      - Virtual Machine scale sets
        - 부하 분산된 동일한 VM 그룹을 만들고 관리,사용자에 따라 vm 갯수를 늘리고 줄임.
        - 확장성
          - scale in-out : 수평 축소, 확장 
          - scale down-up : 수직 축소,확장 
      - Azure Application Gateway(internal) 
        - Layer7에서 작동하는 부하 분산 장치 
      - Azure App Service Environment( Layer 7에서 부하분산하는 장치 )
      - Azure Kubernetes Service
      - Service Fabric

   2. Vnet이 support하는 서비스    //필요하면 vnet을 만들어야 하는 서비스들 

      - Point-to-site VPN

      - Service Endpoints(접근점) : Azure Storage, SQL Database, Cosmos DB, SQL Data Warehouse, PostgreSQL, MySQL, ServiceBus, Event Hub

        해당 서비스를 제공받기 위해서 접근해야 하는 공간. ==> 그게 Vnet이다. 

   3. Vnet이 통합되어 있지 않은 서비스

      - Azure AD, Traffic Manager, 
      
      

4. Vnet 의 Capabilities

   - IP 주소 할당 :  defalut는 Dynamic, static으로 변경 가능.

   - Load Balancing ( L4 layer ) : Internal과 external 부하 분산 장치 

   - Traffic Filtering : Network Security Groups and application security groups

   - Direct Paas endpoint : Storage, Database, Cosmos DB, SQL Datawarehouse 등

     Vnet을 통해 Paas 서비스에 접근 가능 

   - Cross-premises : P2S VPN 등등 ( 20533 ternaling 2-42페이지 참고 )

     Vnet을 ternaling을 만드는 접근점으로 활용 가능
     
     

5. Vnet connectivity options



### L2. Azure Load Balancer

Load Balancer 는 L4에서 작동하는 부하분산 장치. Probes 가 VM들의 상태를 체크함. 

- TCP 3389로 들어오는 연결을 load balancer 가 VM에게 분산함. 

- Baockend pool과 연결된 VM을 만들어야함.

- VM들의 상태를 확인하는 Probes를 만들어야 함. 

  

**참고** 

Cross-Premises

- ![1556257719884](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1556257719884.png)
- Point - to - site : 개인에서 Vnet 으로 VPN(Router)를 통해 통신.
- Site - to - site :  
- Vnet - to - Vnet : 다른 데이터 센터의 Vnet끼리 연결하는 것 
- ExpressRoute : 회사에서 Azure로 direct Ternal을 뚫는 것. 라우터 필요 없음 
- Vnet Peering :  같은 데이터 센터의 두 Vnet 을 하나로 peering함.  



------

## Module 6. Azure Storage and Data Services

### L1. SQL 서버

​	1. 개요	

- Iaas 환경( SQL Server 2017 Enterprise Windows Server 2016)

  VM까지 조정 가능 

- Paas환경(SQL database)

  DB만 관리 가능. VM웨어 포함 백단은 ms가 관리

- sql 포트는 tcp 1433번 port - VM, NSG 방화벽 개방하기

  wf.msc 고급 방화면 인바운드 포트 우클릭 new rule 선택 

- SQL 서버의 인증 모드 // 인증 - 아이디와 패스워드(Credential) 확1인 절차 

  Windows 인증( 같은 도메인 환경일 때 사용 ), 보안이 강함, 중앙 관리

  혼합 인증( Windows(윈도우 계정) 인증 + MS SQL Server(SQL 서버 계정) 인증)

- VM과 NSG에서 방화벽 오픈 해야함 

  - VM : wf.msc로 열어서 new rule, Echo 체크한 후 설정 적용하면 됨. 

  - NSG : cloudshell에서 아래 명령어 실행 or nsg에서 인바운드 규칙 추가 

    ```powershell
    Connect-AzureRMAccount
    Select-AzureRMSubscription <<subscription ID>>
    Get-AzureRmNetworkSecurityGroup -Name "<<nsgName>>" -ResourceGroupName "<<GroupName>>" | 
        Add-AzureRmNetworkSecurityRuleConfig -Name "AllowPing" -Description "Allow Ping" -Access `
        "Allow" -Protocol "*" -Direction "Inbound" -Priority 4002 -SourceAddressPrefix `
        "*" -SourcePortRange "*" -DestinationAddressPrefix "*" -DestinationPortRange "0" |
        Set-AzureRmNetworkSecurityGroup
    
    ```

  

  

![1556599685922](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1556599685922.png)



2. 명령어

   ```mssql
   create database myDB02;
   go
   
   --명령코드에서는 블록 잡고 실행하면 ;go 자동 삽입.
   use myDB01   						-- myDB01 DB에 MyTb1테이블 생성하기 
   Create table MyTb1(
   	idx int not null,
   	name varchar(10) not null,
   	phone varchar(50) null,
   	email varchar(100) null,
   	adress varchar(200) null
   )
   
   Select * from MyTb1;				
   insert into MyTb1(idx,name,phone,email,adress) values (2,'김똘순','111-1111-1112','bbb','부산')
   ```

3. 관리툴

   - SSMS : SQL Server Management Studio //하나의 창에서 모든 sql서버를 관리할수 있도록 한 것.
   - sqlcmd
   - Visual Studio

   대량관리

   - Registered Server  => server 등록하면 더블클릭만으로도 접속 가능 
   
     

------


## Module 4.  Azure Web Apps

### 	L1. web apps 구성

- IaaS 환경의 Web Service : 서버 장비 구성, OS 설치, IIS설치 필수

  - IIS 설치

    - 두 개 같이 연동해야 함.

    - Web Server (TCP 80)

      웹페이지를 client에게 전송. => html of htm을 정적페이지라고 함. client side   // client 브라우저가 해석함.

      asp, java, nodejs 와 같은 DB connection할 수 있는 동적 페이지도 가능. /// 서버가 해석함.

    - FTP Server (TCP 21)

  - Linux( CentOS 7.6 )

    1. APM( Apache, PHP, MySQL(Maria DB)-oracle)

       ```bash
       $yum install httpd php php-mysql php-pod php-gd php-mbstring mariadb mariadb-server 
       $ sudo systemctl enable httpd		#서비스 자동 등록
       $ sudo systemctl enable mariadb
       $ sudo systemctl start httpd		#서비스 시작
       $ sudo systemctl start mariadb-server
       $ sudo systemctl status firewalld	 #방화벽 상태확인
       $ sudo systemctl enable firewalld
       $ sudo systemctl start firewalld		
       $ sudo firewall-cmd --permanent --add-port=80/tcp		#특정포트 오픈
   $ sudo firewall-cmd --permanent --add-port=21/tcp
       $ sudo firewall-cmd --permanent --add-port=3306/tcp		#mariadb포트
       $ sudo firewall-cmd --reload
       $ sudo firewall-cmd --list-ports
       $ find /-name httpd.conf					#웹 서버 설정 파일
       $ cat -n /etc/httpd/conf/httpd.conf | grep DocumentRoot 	#root+directoryindex 확인
       $ cat -n /etc/httpd/conf/httpd.conf | grep DirectoryIndex
       $ sudo vi /var/www/html/index.html				vi 에디터에 확인한 주소 넣고 수정하기
       ```
    
      ip table( 재설정 후 시스템 다시 시작)보다 firewall-cmd( 서비스 중지 x , reload)를 알아두는 게 좋음.

서버를 기준으로 서버로 들어오는 패킷을 컨트롤 하는 것이 inbound rule 

나가는 패킷이 outbound rule

- Rule vs Feature

  - Rule : 서버 서비스(16개), Weh Server (IIS)
  - Feature : 기능( 35개 )

- 웹서버 홈 디렉토리

  %SystemDrive%\inetpub\wwwroot       // %SystemDrive%는 C드라이브를 뜻함.

  개발된 프로그램의 소스코드를 이 폴더에 넣어줘야함. 

- Default Document(기본 문서)

  클라이언트가 접근했을 때, 웹서버 홈 디렉토리 내의 문서 중 제일 처음 열려지는 문서

  IIS에서 Sites아래의 Default Web Site 로 접속, Default Document로 접속하여 수정 가능.

- rpm -qa httpd    //  php// mariadb-server

- sudo  리눅스의 관리자 명령어

- 웹앱은 pass서비스로 IIS까지 설치되어 있음.
- PaaS환경은 scale out이 쉬움. serverless가 우세,  도커로 변환하는 추세, 신축성이 좋음. 
- IaaS환경은 VM용량 자체가 너무 크니까 신축성이 적음 .

Traffic Manager 는 L7 계층에서 다른 데이터센터간의 부하분산처리를 함. DNS기반으로  TCP/UDP의 특정 포트 단위로 분산처리





------

## Module 8. Azure AD

### 1.개요

- Active Directory 개략 

  Directory는  데이터나 프린터, 컴퓨터, 사용자정보 등의 자원이 저장된 용기로, 

  **AD는 네트워크 서비스의 일종으로 네트워크 자원(사용자계정, 그룹계정, 프린터정보, 컴퓨터정보 등..)에 접근하여 관리를 용이하게 하도록 하는 MS의 Directory 서비스**

  Directory( 계정 or 그룹과 같은 object ) Service, X.500( 디렉토리 서비스 표준 

  중앙화된 보안 관리, 중앙화된 관리(GPO)

  Azure에 계정이 있거나 pederation이 있어야 접속 가능 

- 관리 목록

  - 사용자, 그룹, 컴퓨터에 대한 관리

  - 모든 사용자 객체에 대해 보안정책을 적용

  - 공유된 네트워크 자원을 접근, 할당 하는 기능

  - 그룹관리 및 각 그룹에 보안설정 기능

  - AD를 사용하는 어플리케이션에 대해 디렉토리 서비스 제공

- IDA 서비스 : 구현해야하는 순서대로 나열.

  1. AD DS(Directory Service) : 보안을 하나의 단위로 그루핑하여 관리. 

  2. AD CS( Certificate Service ) : 인증서 배포

  3. AD LDS(Lightweight Directory Services) :DS의 일부정보만 load하여 서비스함. // 가볍겠넹 

      AD DS(Active Directory 도메인 서비스)에 필요한 종속성 없이 디렉터리 사용 응용 프로그램에 대한 데이터 저장소 및 검색 기능을 제공 //컨트롤러 설치x

  4. AD RMS( Rights Management Services) : 권한 관리

  5. AD FS(Federation Services) : 회사 대 회사 사이에 federation 신청을 해서 원청 회사와 하청업체 사이를 connect 함. 

  

- 소속그룹에 따른 분류
  - Domain 

    보안의 논리적인 범위, 보안 단위 

    DC(Domain controler) : 도메인 보안 관리 시스템 ( Active Directory 설치 ) //DC가 있어야 도메인 구성 가능 

    WS2012, WS 2016, WS2019 등 서버 OS에서만 설치 가능 

    관리 서비스

    - 인증 밍 허가 서비스 :

      도메인의 모든 계정은 DC에서 만들고, 도메인 접속을 했을 때 DC가 관리

    - 다른 도메인 컨트롤러와 복제 서비스

    - 사용자 계정과 네트워크 자원을 관리하기 위한 관리 서비스

    SSO( Single Sign On )

    AD에는 GPO를 사용하지 않음. 

    IAM(Identity and Access Management) : 계정에 대한 인증 및 권한 부여

  - WorkGroup

    각자 그룹별로 보안 관리 // 따라서 중앙화된 관리가 어려움.
  
    기업의 시스템이 20대 미만일 때,
  
    자신의 시스템의 SAM(Security Accounts Manage) 인증(C:\Windows\System32\config\SAM) 
  
    ID+PW 인증 완료=> 토큰 생성( User SID, Member Group SIDs, Privileges(user rights), other access info)
    GPO로 관리함. 

### 2. 도메인 환경 구성

1. DC 구성

   a. 고정 IP

   b. AD DS role 설치

   c. DC Promotion( 도메인 이름 지정 )

- Domain admins - 모든 관리자 권한을 가짐.

- forest는 전체 확장된 도메인

- 하나의 보안 범위에 다수의 tenant 생성 가능 

### 3.기타

Authentication( 인증 ): credential 확인

Authorization ( 허가 ) : 리소스 접권 권함

서브스크립션 ==> 리소스 접근 권한

서브크립션 > 리소스 그룹 > 리소스 

![1557189351941](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1557189351941.png)

Active Directory의 new User

- global Administrator

- Limited administrator 
- User 



ID user001-aad@siler2312gmail.onmicrosoft.com

PW Caxu4976

![1557189499592](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1557189499592.png)



Multi Factor Authentication : 다단계 인증  ==> ID와 PW를 넣고 한 번 더 인증 받도록 함. 

![1557190280490](C:\Users\wtime\AppData\Roaming\Typora\typora-user-images\1557190280490.png)

- Azure AD Free  || Basic  : Multi Factor Authentication 지원 x 
- Premium1, Premium2에서만 지원





------

## Module 7. Docker

### 1. 개요

- container = docker

### 2. docker 구성

- Docker Engine (커널), 컨테이너들이 HW리소스를 공유해서 쓸수 있도록 해줌. 
- mage ==> doker registry에 저장, 실행 안된 hd에 저장되어 있는 이미지 
- Container ==> 이미지가 로드되어 실행되는 상태
- Dockerfile ==> 도커를 실행 가능 스크립트 //cmd or bash에서 실행
- Docker Regitry ==> 저장소 //docker hub는 공용 레지스트리 

- docker host
  - CE ==>테스트 환경 

### 3. Azure Container Registry

- registry service
  - docker login
  - docker pull ==> 기존 도커 가져오기 //download 
  - docker tag => 이미지 (버전)를 만들며 버전 정보를 넣을 때 사용  
  - docker push ==> 컴퓨터의 이미지를 registry로 upload로 할 때 사용 
  - docker run ==> 도커 실행해서 container로 만들기 
  - docker rmi ==> 이미지 삭제
  - docker rm ==> 컨테이너 삭제

### 4.  multicontainer applications, Docker compose

- docker compose를 설치

- docker-compose.yml

  - 모든 이미지 포함. // 도커 이미지를 sql 등 파일을 다 넣어서 스크립트로 만듦

  - 의존성과 파라미터를 정의 후 집어 넣음.

  - 실행 명령어 

    ```dockerfile
    docker-compose up    #yml파일이 있어야 명령어 실행 가능
    ```

### 5.  Kubernetes cluster( 약어 : K8S )

1. 개요
   -  clustering ==> 호스트 서버들을 하나의 그룹으로 묶은 것. 각각의 서버를 노드라고 함.
   - 하나의 노드가 fail이 되면 다른 서버에서 서비스를 유지할 수 있도록 하는 기술
   - 이 기술이 swram과  Kubernetes(중요, swarm이 가지고 있는 기능을 모두 포함하며 새로운 기술 탑재) 
   - ACS( Azure Container Service )
   - AKS( Azure Kubernetes Service)

2. ACS에서의 쿠버네티스
   - SSH RSA 키 필요
   - Azure AD service 

### . docker 참고 url

==> 크롬 bookmark - docker



시험

- probe가 backendpool에 있는 VM들의 상태를 체크함.

- 로드 밸런서와 트래픽 매니저 두 개 다 부하 분산 장치

- 트래픽 매니저는 다른 데이터센터에도 분산 가능, 로드밸런서는 x

- p2s : 한대의 컴퓨터에서 azure에 있는 vnet과 연결해서 터널링을 만드는 기술

- site to site(s2s) : 라우터로 여러대 컴퓨터와 azure의 vnet 연결하는 기술

- ExpressRoute : 회사와 azure 간 전용선을 이용, 성능과 보안이 좋음

- VNet: peering : 같은 데이터 센터에 있는 컴퓨터를 연결하는 것  ==> Azure 시험에서 많이 나옴.

- Vnet to Vnet :  다른 데이터 센터에 있는 컴퓨터를 연결하는 것

- VPN : 인터넷망을 통해 원격에 있는 컴퓨터를 그 회사네트워크로 넣어주는 기술(터널링 기술)

- 터널링 기술 

  1. PPTP : 거의 안씀.
  2. L2TP : ipsec과 연동
  3. SSTP : 443번 포트
  4. IKEv2 : AP가 바껴도 서버에서 다시 연결해줌

- NAT : 사설 IP를 공인 IP로 변환하는 기술

- powershell az모듈 설치부터 로그인까지

- install => set-executionpolicy => import => connect => get=> select

- 사설ip

  - 10.x.x.x

  - 172.16.~172.31.

  - 192.168.x.x

- kubernetes에서 container를 배포하는 단위 : POD(컨테이너들의 묶음)

- 도커 명령어

  - docker pull ==> 기존 도커 가져오기 //download 
  - docker push ==> 컴퓨터의 이미지를 registry로 upload로 할 때 사용 
  - docker run ==> 도커 실행해서 container로 만들기 

- 

