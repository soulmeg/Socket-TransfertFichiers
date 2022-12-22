# Socket-TransfertFichiers

Progression: 100%

Note: Za no nanao an'ilay réclamation tanaty mp tamin'ny atoandro iny azafady, mikasika an'ilay vidéo tsy mbola afaka nalefa teo 

FONCTIONNALITE:
	.ClientSocket.java: un client envoi un fichier depuis le repertoire vers un serveur "Server.java"
	.Server.java: _Ce serveur recoit ensuite le fichier et le stock dans le dossier "file"
		      _Ensuite le fichier recu est diviser en 3 parties a travers 3 serveurs ("Serveur1.java","Serveur2.java","Serveur3.java"),puis stocker de chaque partie dans file1,file2 et file3
		      _La fonction "send_restituate_file" permet de restituer ces 3 fichiers coupes et de l'envoyer au "FinalServer.java" qui est un autre server

	.FinalServer.java : _Ce serveur recoit le fichier reconstituer et le stock dans "final_file"

	.Client_receive.java : Dans "final_file",ce client choisi un fichier a telecharger (et qui est stocker dans le DOWNLOAD FILE)

Les **.bat servent a executer chaque serveurs et client
(LE REPERTOIRE DE CE PROJET EST SPECIFIE)
