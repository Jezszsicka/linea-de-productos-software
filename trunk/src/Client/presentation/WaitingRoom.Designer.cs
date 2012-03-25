namespace Client.presentation
{
    partial class WaitingRoom
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(WaitingRoom));
            this.pnlFondo = new System.Windows.Forms.Panel();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.btnProfile = new System.Windows.Forms.Button();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.ChatTab = new System.Windows.Forms.TabPage();
            this.participants = new System.Windows.Forms.ListBox();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.txtMessages = new System.Windows.Forms.RichTextBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.button3 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnSend = new System.Windows.Forms.Button();
            this.txtMessage = new System.Windows.Forms.TextBox();
            this.pnlFondo.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.ChatTab.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // pnlFondo
            // 
            this.pnlFondo.Controls.Add(this.groupBox2);
            this.pnlFondo.Controls.Add(this.tabControl1);
            this.pnlFondo.Controls.Add(this.txtMessages);
            this.pnlFondo.Controls.Add(this.btnExit);
            this.pnlFondo.Controls.Add(this.groupBox1);
            this.pnlFondo.Controls.Add(this.panel1);
            this.pnlFondo.Controls.Add(this.btnSend);
            this.pnlFondo.Controls.Add(this.txtMessage);
            this.pnlFondo.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlFondo.Location = new System.Drawing.Point(0, 0);
            this.pnlFondo.Name = "pnlFondo";
            this.pnlFondo.Size = new System.Drawing.Size(761, 450);
            this.pnlFondo.TabIndex = 0;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.btnProfile);
            this.groupBox2.Location = new System.Drawing.Point(578, 11);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(162, 53);
            this.groupBox2.TabIndex = 7;
            this.groupBox2.TabStop = false;
            // 
            // btnProfile
            // 
            this.btnProfile.Image = ((System.Drawing.Image)(resources.GetObject("btnProfile.Image")));
            this.btnProfile.Location = new System.Drawing.Point(116, 9);
            this.btnProfile.Name = "btnProfile";
            this.btnProfile.Size = new System.Drawing.Size(40, 40);
            this.btnProfile.TabIndex = 0;
            this.btnProfile.UseVisualStyleBackColor = true;
            this.btnProfile.Click += new System.EventHandler(this.btnProfile_Click);
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.ChatTab);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Location = new System.Drawing.Point(578, 70);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(162, 313);
            this.tabControl1.TabIndex = 0;
            // 
            // ChatTab
            // 
            this.ChatTab.Controls.Add(this.participants);
            this.ChatTab.Location = new System.Drawing.Point(4, 22);
            this.ChatTab.Name = "ChatTab";
            this.ChatTab.Padding = new System.Windows.Forms.Padding(3);
            this.ChatTab.Size = new System.Drawing.Size(154, 287);
            this.ChatTab.TabIndex = 0;
            this.ChatTab.Text = "Chat";
            this.ChatTab.UseVisualStyleBackColor = true;
            // 
            // participants
            // 
            this.participants.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.participants.FormattingEnabled = true;
            this.participants.Items.AddRange(new object[] {
            "\" \""});
            this.participants.Location = new System.Drawing.Point(3, 0);
            this.participants.Name = "participants";
            this.participants.Size = new System.Drawing.Size(155, 288);
            this.participants.TabIndex = 0;
            // 
            // tabPage2
            // 
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(154, 287);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Friends";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // txtMessages
            // 
            this.txtMessages.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtMessages.Location = new System.Drawing.Point(32, 70);
            this.txtMessages.Name = "txtMessages";
            this.txtMessages.ReadOnly = true;
            this.txtMessages.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            this.txtMessages.Size = new System.Drawing.Size(514, 313);
            this.txtMessages.TabIndex = 6;
            this.txtMessages.Text = " Welcome to the board game application";
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(659, 404);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(81, 23);
            this.btnExit.TabIndex = 5;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.button3);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Location = new System.Drawing.Point(32, 11);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(202, 53);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(64, 10);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(42, 38);
            this.button3.TabIndex = 2;
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(6, 9);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(40, 40);
            this.button1.TabIndex = 1;
            this.button1.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.AppWorkspace;
            this.panel1.Location = new System.Drawing.Point(578, 70);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(162, 313);
            this.panel1.TabIndex = 3;
            // 
            // btnSend
            // 
            this.btnSend.Location = new System.Drawing.Point(471, 404);
            this.btnSend.Name = "btnSend";
            this.btnSend.Size = new System.Drawing.Size(75, 23);
            this.btnSend.TabIndex = 2;
            this.btnSend.Text = "Send";
            this.btnSend.UseVisualStyleBackColor = true;
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // txtMessage
            // 
            this.txtMessage.Location = new System.Drawing.Point(32, 404);
            this.txtMessage.Name = "txtMessage";
            this.txtMessage.Size = new System.Drawing.Size(433, 20);
            this.txtMessage.TabIndex = 1;
            this.txtMessage.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtMessage_KeyUp);
            // 
            // WaitingRoom
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(761, 450);
            this.Controls.Add(this.pnlFondo);
            this.Name = "WaitingRoom";
            this.Text = "WaitingRoom";
            this.Load += new System.EventHandler(this.WaitingRoom_Load);
            this.pnlFondo.ResumeLayout(false);
            this.pnlFondo.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.tabControl1.ResumeLayout(false);
            this.ChatTab.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlFondo;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnSend;
        private System.Windows.Forms.TextBox txtMessage;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.RichTextBox txtMessages;
        private System.Windows.Forms.Button btnProfile;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage ChatTab;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ListBox participants;

    }
}