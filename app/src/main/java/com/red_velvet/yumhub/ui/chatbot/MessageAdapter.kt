package com.red_velvet.yumhub.ui.chatbot
import android.util.Log
import com.red_velvet.yumhub.BR
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
class MessageAdapter (item: List<ChatBotResultUIState>) :
    BaseAdapter<ChatBotResultUIState>(item) {

    private var items =item
    override val layoutId: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        Log.d("AYA_VIEW_TYPE",viewType.toString())
        when(viewType){
            HUMAN_MESSAGE -> {
                return HumanMessageViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_human_message,
                        parent,
                        false
                    )
                )
            }
            CHATBOT_MESSAGE -> {
                return ChatBotMessageViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_chatbot_message,
                        parent,
                        false
                    )
                )
            }

        }
        return super.onCreateViewHolder(parent, viewType)
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (position < items.size) {
            val currentItem = items[position]
            when (holder) {
                is HumanMessageViewHolder -> {
                    holder.binding.run{
                        setVariable(BR.item, currentItem)
                    }
                }
                is ChatBotMessageViewHolder -> {
                    holder.binding.run { setVariable(BR.item, currentItem) }
                }
            }
        }
        super.onBindViewHolder(holder, position)
    }


    override fun getItemViewType(position: Int): Int {
        if (position < items.size) {
            val item = items[position]
            return if (item.isQuestion) {
                HUMAN_MESSAGE
            } else {
                CHATBOT_MESSAGE
            }
        }
        return super.getItemViewType(position)
    }
    override fun setItems(newItems: List<ChatBotResultUIState>) {
        items = newItems
        super.setItems(items)
    }

    override fun areItemsTheSame(oldItem: ChatBotResultUIState, newItem: ChatBotResultUIState): Boolean {
        return oldItem == newItem
    }

    class HumanMessageViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    class ChatBotMessageViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    companion object  {
        const val HUMAN_MESSAGE = 1
        const val CHATBOT_MESSAGE = 2
    }

}