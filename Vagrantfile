Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/bionic64"  # 或 ubuntu/focal64

  config.vm.network "forwarded_port", guest: 3306, host: 3306  # 端口轉發

  # 同步資料夾
  config.vm.synced_folder "D:/ubutu/CloudNotePro", "/home/vagrant/data"

  # 設定虛擬機資源
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
    vb.cpus = 2
  end

  # 設置虛擬機啟動的超時時間為 10 分鐘
  config.vm.boot_timeout = 600000

  # 安裝 OpenSSH Server 並修改 SSH 配置
  config.vm.provision "shell", inline: <<-SHELL
    sudo apt-get update
    sudo apt-get install -y openssh-server

    sudo sed -i 's/#PasswordAuthentication yes/PasswordAuthentication yes/' /etc/ssh/sshd_config
    sudo sed -i 's/#PubkeyAuthentication yes/PubkeyAuthentication yes/' /etc/ssh/sshd_config

    sudo sed -i 's/#Subsystem sftp \/usr\/lib\/openssh\/sftp-server/Subsystem sftp internal-sftp/' /etc/ssh/sshd_config
    sudo systemctl restart sshd
  SHELL

  # 禁用自動插入 SSH 密鑰
  config.ssh.insert_key = false
end
