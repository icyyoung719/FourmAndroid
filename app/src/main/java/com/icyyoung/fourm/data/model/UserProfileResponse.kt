package com.icyyoung.fourm.data.model
//
//class UserProfileSerializer(serializers.ModelSerializer):
//class Meta:
//    model = User_profile
//fields = ['id', 'user', 'bio']
//read_only_fields = ['user']
data class UserProfileResponse (
    val id: Int,
    val user: User,
    val bio: String
)