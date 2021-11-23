/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Model.TaiKhoan;

/**
 *
 * @author Hai
 */
public class authenticated {
    public static TaiKhoan use = null;

    public static void clear() {
        authenticated.use = null;

    }
}
