package com.example.retrofitwithmvvm.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.retrofitwithmvvm.Interface.loginInterface
import com.example.retrofitwithmvvm.ApiUtils.ApiUtils
import com.example.retrofitwithmvvm.Model.LoginModel
import com.example.retrofitwithmvvm.Model.LoginUer
import com.example.retrofitwithmvvm.R
import com.example.retrofitwithmvvm.ViewMdodel.ViewModleLogin
import com.example.retrofitwithmvvm.databinding.FragmentLoginBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!
   lateinit var  viewModle:ViewModleLogin


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =FragmentLoginBinding.inflate(inflater, container, false)

    val apiInterface = ApiUtils.userLogin().create(loginInterface::class.java)
//     viewModle=ViewModelProvider(this).get(ViewModleLogin::class.java)
//       viewModle.myLiveData.observe(viewLifecycleOwner){
//           binding.simpleText.text=it
//       }


    binding.btnLogin.setOnClickListener {

        binding.prograssbar.visibility=View.VISIBLE
        binding.tvLoginView.visibility=View.INVISIBLE
        val username=binding.email.text.toString().trim()
        val password=binding.password.text.toString().trim()
             if(CheckField()){
                 val call = apiInterface.login(LoginUer(username,password))
                 call.enqueue(object : Callback<LoginModel> {
                     override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                         if (response.isSuccessful) {
                             val model = response.body()
                             if(username== model?.data?.user?.email)
                             {
                                 binding.prograssbar.visibility=View.INVISIBLE
                                 binding.tvLoginView.visibility=View.VISIBLE
                                 findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                             }else{
                                 binding.prograssbar.visibility=View.INVISIBLE
                                 binding.tvLoginView.visibility=View.VISIBLE
                                 Toast.makeText(context, "Enter correct Email", Toast.LENGTH_SHORT).show()
                             }
                         } else {
                             binding.prograssbar.visibility=View.INVISIBLE
                             binding.tvLoginView.visibility=View.VISIBLE
                             Toast.makeText(context, "response error", Toast.LENGTH_SHORT).show()
                         }
                     }
                     override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                         binding.prograssbar.visibility=View.INVISIBLE
                         binding.tvLoginView.visibility=View.VISIBLE
                         Toast.makeText(context, "network error", Toast.LENGTH_SHORT).show()
                     }
                 })

             }


    }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_blankFragment)

        }


        return binding.root
    }
    fun  CheckField() :Boolean{
        val username=binding.email.text.toString().trim()
        val password=binding.password.text.toString().trim()
        if(username.isEmpty()){
            binding.email.error = "Enter Email"
            binding.email.requestFocus()
            binding.prograssbar.visibility=View.INVISIBLE
            binding.tvLoginView.visibility=View.VISIBLE
            return  false
        }else if( password.isEmpty()){
            binding.prograssbar.visibility=View.INVISIBLE
            binding.tvLoginView.visibility=View.VISIBLE
            Toast.makeText(context,"Enter Password",Toast.LENGTH_SHORT).show()
            return  false
        }
        return  true
    }


}

