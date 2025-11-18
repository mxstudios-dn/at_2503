package Exercises;

class StringExcersises {

    public static void main(String[] args) {

        String chuoiChinh1 = "Python Exercises";
        String chuoiChinh2 = "Python Exercise";

        String hauTo = "se";
        boolean ketQua1 = kiemTraKetThucBangSubString(chuoiChinh1, hauTo);
        boolean ketQua2 = kiemTraKetThucBangSubString(chuoiChinh2, hauTo);

        System.out.println("\"" + chuoiChinh1 + "\" kết thúc bằng \"" + hauTo + "\"? " + ketQua1);
        System.out.println("\"" + chuoiChinh2 + "\" kết thúc bằng \"" + hauTo + "\"? " + ketQua2);
    }
    public static boolean kiemTraKetThucBangSubString(String chuoi, String hauTo) {

        int doDaiChuoi = chuoi.length();
        int doDaiHauTo = hauTo.length();

        if (doDaiHauTo > doDaiChuoi) {
            return false;
        }
        int viTriBatDau = doDaiChuoi - doDaiHauTo;
        String phanCuoiCuaChuoi = chuoi.substring(viTriBatDau);
        return phanCuoiCuaChuoi.equals(hauTo);
    }
}

