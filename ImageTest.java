import java.io.*;

public class ImageTest {
    public static void main(String[] args) {
        try {
            //(1)File�I�u�W�F�N�g�̐���
            File directory1 = new File("c:\\image", "FILE_CLASS");
            //(2)File�I�u�W�F�N�g�̐���
            File file1 = new File(directory1, "a.txt");
            //(3)�f�B���N�g���̍쐬
            directory1.mkdir();
            //(4)�t�@�C���̍쐬
            file1.createNewFile();

            if(file1.exists()) {  //(5)�t�@�C���������true��Ԃ�
                //(6)�t�@�C������\��
                System.out.println("�t�@�C�����F" + file1.getName());
                //(7)�t�@�C���̊i�[�f�B���N�g������\��
                System.out.println("�i�[�f�B���N�g�����F" + file1.getParent());
                //(8)�t�@�C����PATH����\��
                System.out.println("PATH���F" + file1.getAbsolutePath());
                System.out.println("�|�|�|�|�|�|�|�|�|�|�|�|�|�|�|�|");
            }

            //(9)�f�B���N�g�����̃t�@�C���E�f�B���N�g���ꗗ���擾
            String[] directory_list = directory1.list();
            for (int i = 0; i < directory_list.length; i++) {
                //(10)�t�@�C���E�f�B���N�g���ꗗ�̕\��
                System.out.println("�f�B���N�g���̒��g�F" + directory_list[i]);
            }
        } catch(IOException e) {
        }
    }
}